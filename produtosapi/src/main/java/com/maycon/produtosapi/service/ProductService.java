package com.maycon.produtosapi.service;


import com.maycon.produtosapi.dto.request.ProductRequestDTO;
import com.maycon.produtosapi.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    ProductResponseDTO findById(Long id);

    List<ProductResponseDTO> findAll();

    ProductResponseDTO register(ProductRequestDTO productDto);

    ProductResponseDTO update(Long id, ProductRequestDTO personDTO);

    String delete(Long id);
}
