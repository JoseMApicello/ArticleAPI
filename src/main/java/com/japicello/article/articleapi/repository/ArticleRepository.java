package com.japicello.article.articleapi.repository;

import com.japicello.article.articleapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, String> {
    Optional<Article> findById(String id);
}
