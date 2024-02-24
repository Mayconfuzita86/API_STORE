package com.maycon.produtosapi.controller;

import com.maycon.produtosapi.dto.request.ProductRequestDTO;
import com.maycon.produtosapi.dto.response.ProductResponseDTO;
import com.maycon.produtosapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> register(@RequestBody ProductRequestDTO productRequestDTO, UriComponentsBuilder uriBuilder) {

        ProductResponseDTO productResponseDTO = productService.register(productRequestDTO);

        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(productResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(productResponseDTO);
    }

    //@PutMapping(value = "/{id}")
    //public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductRequestDTO productDTO, @PathVariable(name = "id") Long id) {
    //    return ResponseEntity.ok().body(productService.update(id,productDTO));
    //}

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductRequestDTO productDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(productService.update(id,productDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(productService.delete(id));
    }
}
