package cnu.swabeimage.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDTO {
    private MultipartFile imageFile;
    private String fileUrl;
}
