package com.japicello.article.articleapi.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleUpdateRequest {

    @Size(max = 200)
    private String description;

    @Size(max = 10)
    private String model;
}
