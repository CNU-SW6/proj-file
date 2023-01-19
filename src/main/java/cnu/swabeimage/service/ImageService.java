package cnu.swabeimage.service;

import cnu.swabeimage.dto.ImageDTO;
import cnu.swabeimage.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public String saveImageFile(ImageDTO imageDTO) {
        boolean isSuccess = imageRepository.save(imageDTO);
        if(isSuccess) {
            return imageDTO.getFileUrl();
        } else {
            return "";
        }
    }
}
