package com.maycon.produtosapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_products")
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "price", nullable = false)
    private double price;
    private String image;

    @Builder
    public Product(String name, Integer quantity, double price, String image) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }
}



//Produto deve ter nome, preço, quantidade e foto(s)
//Cadastro de produtos deve ter campos obrigatórios(nome, preço, quantidade)