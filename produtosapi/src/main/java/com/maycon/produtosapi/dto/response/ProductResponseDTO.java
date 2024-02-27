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

    public ProductResponseDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        if (product.getImage() != null) {
            this.image = product.getImage().getName();
        } else {
            this.image = null;
        }
    }
}
