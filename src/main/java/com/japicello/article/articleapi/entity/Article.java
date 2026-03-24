package com.japicello.article.articleapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "id", length = 10, nullable = false, updatable = false)
    @Pattern(regexp = "^[A-Za-z0-9]{10}$")
    private String id;

    @Column(name = "name", length = 20, nullable = false, updatable = false)
    @Size(max = 20)
    private String name;

    @Column(name = "description", length = 200)
    @Size(max = 200)
    private String description;

    @Column(name = "price", precision = 10, scale = 2, nullable = false, updatable = false)
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Column(name = "model", length = 10)
    @Size(max = 10)
    private String model;
}
