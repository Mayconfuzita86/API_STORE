package com.maycon.produtosapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequestDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private double price;
}
