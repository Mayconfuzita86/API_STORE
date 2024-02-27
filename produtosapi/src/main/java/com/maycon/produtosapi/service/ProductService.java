package com.maycon.produtosapi.service;

import com.maycon.produtosapi.dto.request.ProductRequestDTO;
import com.maycon.produtosapi.dto.response.ProductResponseDTO;
import com.maycon.produtosapi.entity.Product;
import com.maycon.produtosapi.repository.ProductRepository;
import com.maycon.produtosapi.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductResponseDTO findById(Long id) {
        return productMapper.toProductDTO(returnProduct(id));
    }

    public List<ProductResponseDTO> findByName(String name) {
        return productMapper.toProductDTO(returnProductByName(name));
    }

    public List<ProductResponseDTO> findAll() {
        return productMapper.toProductDTO(productRepository.findAll());
    }

    public ProductResponseDTO register(ProductRequestDTO productDto) {

        Product product = productMapper.toProduct(productDto);

        return productMapper.toProductDTO(productRepository.save(product));
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO productDto) {

        Product product = returnProduct(id);

        productMapper.updateProductData(product,productDto);

        return productMapper.toProductDTO(productRepository.save(product));
    }


    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Product id: "+id+" deleted";
    }

    private Product returnProduct(Long id){
       return productRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Produto não localizado"));
    }

    private List<Product> returnProductByName(String name){

        if(name.isBlank())
            return productRepository.findAll();

        return productRepository.findByNameContaining(name);
    }
}
