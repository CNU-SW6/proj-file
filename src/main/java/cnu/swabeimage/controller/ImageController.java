package cnu.swabeimage.controller;

import cnu.swabeimage.dto.ImageDTO;
import cnu.swabeimage.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/api/image-upload")
    public String uploadImage(@RequestPart MultipartFile file) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageFile(file);
        return imageService.saveImageFile(imageDTO);
    }
}
