package com.japicello.article.articleapi.services;

import com.japicello.article.articleapi.dto.ArticleResponse;
import com.japicello.article.articleapi.dto.ArticleUpdateRequest;
import com.japicello.article.articleapi.entity.Article;
import com.japicello.article.articleapi.exception.ArticleNotFoundException;
import com.japicello.article.articleapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    public ArticleResponse findById(String id) {
        Article article = repository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Artículo con ID " + id + " no encontrado"));
        return mapToResponse(article);
    }

    @Transactional
    public ArticleResponse update(String id, ArticleUpdateRequest request) {
        Article article = repository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("Artículo con ID " + id + " no encontrado"));

        if (request.getDescription() != null) {
            article.setDescription(request.getDescription());
        }
        if (request.getModel() != null) {
            article.setModel(request.getModel());
        }

        Article updated = repository.save(article);
        return mapToResponse(updated);
    }

    private ArticleResponse mapToResponse(Article articulo) {
        return new ArticleResponse(
                articulo.getId(),
                articulo.getName(),
                articulo.getDescription(),
                articulo.getPrice(),
                articulo.getModel()
        );
    }
}