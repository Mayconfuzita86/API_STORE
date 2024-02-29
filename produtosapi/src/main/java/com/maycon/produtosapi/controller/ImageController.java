package com.maycon.produtosapi.controller;


import com.maycon.produtosapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/image")
@RequiredArgsConstructor
public class ImageController {

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Por favor, selecione um arquivo para enviar.", HttpStatus.BAD_REQUEST);
        }

        // Verificar se é uma imagem JPEG válida
        if (!file.getContentType().equals("image/jpeg")) {
            return new ResponseEntity<>("Apenas imagens JPEG são aceitas.", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(imageService.createImage(file));
    }

    @GetMapping("/{fileName:.+}")
    public ResponseEntity<Resource> viewImage(@PathVariable String fileName) {
        try {
            // Monta o caminho completo do arquivo
            Path imagePath = Paths.get(UPLOAD_DIR).resolve(fileName);
            Resource resource = new UrlResource(imagePath.toUri());

            // Verifica se o arquivo existe
            if (!resource.exists() || !resource.isReadable()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Define o cabeçalho para o tipo de mídia da imagem
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
