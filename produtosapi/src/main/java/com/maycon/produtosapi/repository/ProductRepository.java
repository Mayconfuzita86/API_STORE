package com.maycon.produtosapi.repository;

import com.maycon.produtosapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Metodo do JPA, isso ja faz por de traz dos panos a busca 'like' nome
    List<Product> findByNameContaining(String name);

}
