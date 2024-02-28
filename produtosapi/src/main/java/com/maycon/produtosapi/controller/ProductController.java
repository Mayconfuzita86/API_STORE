package com.maycon.produtosapi.controller;

import com.maycon.produtosapi.dto.request.ProductRequestDTO;
import com.maycon.produtosapi.dto.request.PurchaseRequestDTO;
import com.maycon.produtosapi.dto.response.ProductResponseDTO;
import com.maycon.produtosapi.dto.response.PurchaseResponseDTO;
import com.maycon.produtosapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping(value = "/search/{name}")
    public ResponseEntity<List<ProductResponseDTO>> findByName(@PathVariable(name = "name") String name ) {
        return ResponseEntity.ok().body(productService.findByName(name));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<ProductResponseDTO>> searchAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> register(@RequestPart("productData") ProductRequestDTO productRequestDTO,
                                                       UriComponentsBuilder uriBuilder, @RequestPart("image") MultipartFile image) {

        ProductResponseDTO productResponseDTO = productService.register(productRequestDTO, image);

        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(productResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(productResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductRequestDTO productDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(productService.update(id,productDTO));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<PurchaseResponseDTO> purchase(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        return ResponseEntity.ok().body(productService.purchase(purchaseRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(productService.delete(id));
    }
}
