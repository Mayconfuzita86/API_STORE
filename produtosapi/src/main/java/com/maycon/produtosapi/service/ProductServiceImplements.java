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
public class ProductServiceImplements implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO findById(Long id) {
        return productMapper.toProductDTO(returnProduct(id));
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return productMapper.toProductDTO(productRepository.findAll());
    }

    @Override
    public ProductResponseDTO register(ProductRequestDTO productDto) {

        Product product = productMapper.toProduct(productDto);

        return productMapper.toProductDTO(productRepository.save(product));

    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO productDto) {

        Product product = returnProduct(id);

        productMapper.updateProductData(product,productDto);

        return productMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Product id: "+id+" deleted";
    }

    private Product returnProduct(Long id){
       return productRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Produto não localizado"));
    }
}
