package com.maycon.produtosapi.dto.request;

import lombok.Getter;

@Getter
public class ProductRequestDTO {

    private String name;
    private Integer quantity;
    private double price;
    private String image;
}
