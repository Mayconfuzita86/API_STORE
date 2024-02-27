package com.maycon.produtosapi.dto.request;

import com.maycon.produtosapi.entity.Image;
import lombok.Getter;

@Getter
public class ProductRequestDTO {

    private String name;
    private Integer quantity;
    private double price;
    private Image image;
}
