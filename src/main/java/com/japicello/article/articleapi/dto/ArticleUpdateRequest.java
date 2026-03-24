package com.japicello.article.articleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleUpdateRequest {

    @Schema(description = "Nueva informacion del articulo" , example ="Case SFF para estructuras minimalistas")
    @Size(max = 200)
    private String description;

    @Schema(description = "Nueva informacion del modelo" , example ="JEMIP 660 Star Braker")
    @Size(max = 10)
    private String model;
}
