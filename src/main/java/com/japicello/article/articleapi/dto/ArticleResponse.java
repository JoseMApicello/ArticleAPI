package com.japicello.article.articleapi.dto;


import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String model;
}
