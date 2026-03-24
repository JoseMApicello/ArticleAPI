package com.japicello.article.articleapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ArticleAPI")
                        .version("1.0")
                        .description("API REST que emula el servicio de" +
                                " una empresa para consultar y actualizar" +
                                " productos de su catalogo por medio de peticiones " +
                                "GET y PUT utilizando el ID"));
    }
}