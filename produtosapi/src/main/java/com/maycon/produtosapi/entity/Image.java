package com.maycon.produtosapi.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_images")
@NoArgsConstructor
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToOne(mappedBy = "image")
    private Product product;

}
