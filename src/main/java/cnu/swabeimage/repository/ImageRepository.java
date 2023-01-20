package cnu.swabeimage.repository;

import cnu.swabeimage.dto.ImageDTO;
import cnu.swabeimage.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
@Slf4j
public class ImageRepository {
    public boolean save(ImageDTO imageDTO) {
        try {
            StringBuilder sb = new StringBuilder();
            String storageUrl = "C:\\Users\\user\\Desktop\\storage\\";
            String originalFileName = imageDTO.getImageFile().getOriginalFilename();
            String generatedString = RandomUtil.lowerAlpa(10);
            sb.append(generatedString);
            sb.append(originalFileName);
            String finalFileName = sb.toString();
            log.info(finalFileName);
            File file = new File(storageUrl + finalFileName);
            file.getParentFile().mkdir();
            imageDTO.getImageFile().transferTo(file);
            imageDTO.setFileUrl(storageUrl);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public Resource findByFileName(String fileName) {
        StringBuilder sb = new StringBuilder();
        String storageUrl = "C:\\Users\\user\\Desktop\\storage\\";
        sb.append(storageUrl);
        sb.append(fileName);
        sb.append(".png");
        log.info(sb.toString());
        FileSystemResource resource = new FileSystemResource(sb.toString());
        return resource;
    }
}
