package com.maycon.produtosapi.repository;

import com.maycon.produtosapi.entity.Image;
import com.maycon.produtosapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Product> findByName(String name);
    boolean existsByName(String name);

}
