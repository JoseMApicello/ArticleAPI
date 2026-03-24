package com.japicello.article.articleapi.controllers;

import com.japicello.article.articleapi.dto.ArticleResponse;
import com.japicello.article.articleapi.dto.ArticleUpdateRequest;
import com.japicello.article.articleapi.services.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@Tag(name = "Artículos", description = "Endpoints para gestionar artículos")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @Operation(
            summary = "Obtener un artículo por su ID",
            description = "Devuelve los detalles completos de un artículo específico.",
            parameters = {
                    @Parameter(name = "id", description = "Identificador único del artículo", required = true, example = "ART9999999")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artículo encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleResponse.class))),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable String id) {
        ArticleResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar un artículo existente",
            description = "Actualiza los campos enviados de un artículo. El ID no puede modificarse.",
            parameters = {
                    @Parameter(name = "id", description = "ID del artículo a actualizar", required = true, example = "ART8888888")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artículo actualizado correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleResponse.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos (ej: campos vacíos o formato incorrecto)",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(
            @PathVariable String id,
            @Valid @RequestBody ArticleUpdateRequest request) {
        ArticleResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }
}