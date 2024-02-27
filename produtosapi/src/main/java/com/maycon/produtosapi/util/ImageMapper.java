package com.maycon.produtosapi.util;

import com.maycon.produtosapi.dto.response.ImageResponseDTO;
import com.maycon.produtosapi.entity.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageResponseDTO toImageDTO(Image image) {
        return new ImageResponseDTO(image);
    }

}
