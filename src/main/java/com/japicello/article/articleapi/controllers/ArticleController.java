package com.japicello.article.articleapi.controllers;

import com.japicello.article.articleapi.dto.ArticleResponse;
import com.japicello.article.articleapi.dto.ArticleUpdateRequest;
import com.japicello.article.articleapi.services.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleController {


    @Autowired
    private ArticleService service;

    @Operation
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticulo(@PathVariable String id) {

        ArticleResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticulo(
            @PathVariable String id,
            @Valid @RequestBody ArticleUpdateRequest request) {
        ArticleResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }
}

