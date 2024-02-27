package com.maycon.produtosapi.dto.response;

import com.maycon.produtosapi.entity.Image;
import lombok.Getter;

@Getter
public class ImageResponseDTO {

    private Long id;
    private String name;

    public ImageResponseDTO(Image image){
        this.id = image.getId();
        this.name = image.getName();
    }
}
