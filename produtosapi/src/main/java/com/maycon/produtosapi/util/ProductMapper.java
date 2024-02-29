package com.maycon.produtosapi.util;

import com.maycon.produtosapi.dto.request.ProductRequestDTO;
import com.maycon.produtosapi.dto.request.ProductUpdateRequestDTO;
import com.maycon.produtosapi.dto.response.ProductResponseDTO;
import com.maycon.produtosapi.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequestDTO productDTO) {

        return Product.builder()
                .name(productDTO.getName())
                .quantity(productDTO.getQuantity())
                .price(productDTO.getPrice())
                .build();
    }

    public ProductResponseDTO toProductDTO(Product product) {
        return new ProductResponseDTO(product);
    }

    public List<ProductResponseDTO> toProductDTO(List<Product> productList){
        return productList.stream().map(ProductResponseDTO::new).collect((Collectors.toList()));
    }

    public void updateProductData(Product product, ProductUpdateRequestDTO productDTO){

        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
    }

}
