package com.maycon.produtosapi.dto.response;

import com.maycon.produtosapi.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private double price;
    private String image;

    public ProductResponseDTO(Product products){
        this.id = products.getId();
        this.name = products.getName();
        this.quantity = products.getQuantity();
        this.price = products.getPrice();
        this.image = products.getImage();
    }
}
