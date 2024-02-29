package com.maycon.produtosapi.service;

import com.maycon.produtosapi.dto.response.ImageResponseDTO;
import com.maycon.produtosapi.entity.Image;
import com.maycon.produtosapi.repository.ImageRepository;
import com.maycon.produtosapi.util.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    private final ImageMapper imageMapper;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    public ImageResponseDTO createImage(MultipartFile file){
        return imageMapper.toImageDTO(this.coreCreateImage(file));
    }

    public Image coreCreateImage(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new RuntimeException("Por favor, selecione um arquivo para enviar.");
        }

        // Verificar se é uma imagem JPEG válida
        if (!file.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Apenas imagens JPEG são aceitas.");
        }

        try {
            //tenta salvar na pasta
            String imageName = saveImageFile(file.getBytes());

            try {
                //tenta salvar no banco o nome de referência
                Image image = new Image();
                image.setName(imageName);
                imageRepository.save(image);

                return image;

            } catch (Exception e) {
                deleteImageFile(imageName);
            }


        } catch (Exception e) {

        }
        return null;
    }

    private String saveImageFile(byte[] file) {
        try {
            // Gerar um nome único para o arquivo
            String uniqueFileName = makeUniqueImageName();

            if (Files.notExists(Paths.get(UPLOAD_DIR))) {
                Files.createDirectories(Paths.get(UPLOAD_DIR));
            }

            // Salvar o arquivo para o diretório especificado
            Path path = Paths.get(UPLOAD_DIR).resolve(uniqueFileName);
            Files.write(path, file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            return uniqueFileName;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao enviar o arquivo.");
        }
    }

    private String makeUniqueImageName() {

        String uniqueFileName;

        while (true) {
            uniqueFileName = UUID.randomUUID().toString() + ".jpg";
            if (imageRepository.existsByName(uniqueFileName))
                continue;

            return uniqueFileName;
        }
    }

    private Boolean deleteImageFile(String imageName) {

        File arquivo = new File(UPLOAD_DIR + imageName);

        if (arquivo.exists()) {
            return arquivo.delete();
        }
        return true;
    }

}
