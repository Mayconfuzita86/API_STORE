package com.maycon.produtosapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//Em resumo, a necessidade de configurar o CORS emergiu
// à medida que as aplicações web tornaram-se mais complexas e começaram
// a utilizar várias origens de recursos. As políticas CORS foram introduzidas
// para garantir que os desenvolvedores tenham meios controlados e seguros
// para permitir ou bloquear solicitações entre diferentes domínios.

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("*");
    }
}

