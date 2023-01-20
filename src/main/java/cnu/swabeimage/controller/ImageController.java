package cnu.swabeimage.controller;

import cnu.swabeimage.dto.ImageDTO;
import cnu.swabeimage.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/api/images")
    public String uploadImage(@RequestPart MultipartFile file) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageFile(file);
        return imageService.saveImageFile(imageDTO);
    }

    /**
     * 이 부분 Domain DTO 나누는거 보고 수정
     */
    @GetMapping("/api/images/{fileName}")
    public ResponseEntity<Resource> inquiryImage(@PathVariable String fileName) throws IOException {

        String storageUrl = "C:\\Users\\user\\Desktop\\storage\\";
        HttpHeaders header = new HttpHeaders();
        Resource resource = imageService.getImageFile(fileName);
        Path filePath = null;
        filePath = Paths.get(storageUrl + fileName+".png");
        log.info(String.valueOf(filePath.getFileName()));
        header.add("Content-Type", Files.probeContentType(filePath));
        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
    }

}
