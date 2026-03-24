package com.japicello.article.articleapi.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {

    @Schema(description = "ID unico del articulo" , example = "ART7777777")
    private String id;

    @Schema(description = "Nombre del articulo" , example = "Memoria Ram")
    private String name;

    @Schema(description = "Informacion adicional del articulo" , example = "Memoria ram de 5600MHz , UDIMM")
    private String description;

    @Schema(description = "Coste del articulo" , example = "200.00")
    private BigDecimal price;

    @Schema(description = "Modelo especifico del producto" , example = "DDR5 5600Mhz UDIMM")
    private String model;
}
