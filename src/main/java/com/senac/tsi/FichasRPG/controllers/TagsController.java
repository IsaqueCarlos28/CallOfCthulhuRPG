package com.senac.tsi.FichasRPG.controllers;


import com.senac.tsi.FichasRPG.domains.tags.Tag;
import com.senac.tsi.FichasRPG.exceptions.RPGAlreadyExistsException;
import com.senac.tsi.FichasRPG.exceptions.RPGNotFoundException;

import com.senac.tsi.FichasRPG.service.TagServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tags")
@RequestMapping("/tags")
public class TagsController {

    private final TagServices service;

    TagsController(TagServices service) {
        this.service = service;

    }

    @Operation(summary = "Listar todas as Tags",
            description = "Retorna uma lista com todas as Tags existentes no sistema")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<Tag>>> getAll(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }


    @Operation(summary = "Pegar uma Tag pelo id",
            description = "Retorna uma lista com todas as Tags existentes no sistema")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200",description = "Tag retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Tag.class))),//Input invalido
            @ApiResponse(responseCode = "404",description = "Tag não encontrada",
                    content = @Content),//Not Found
            @ApiResponse(responseCode = "400",description = "Input errado",
                    content = @Content)//Input invalido
    })
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Tag>> getTagById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(service.getById(id));
    }



    @Operation(summary = "Pegar uma Tag pelo nome",
            description = "Retorna uma Tag de acordo com o nome da tag")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200",description = "Tag retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Tag.class))),//Input invalido
            @ApiResponse(responseCode = "404",description = "Tag não encontrada",
                    content = @Content),//Not Found
            @ApiResponse(responseCode = "400",description = "Input errado",
                    content = @Content)//Input invalido
    })
    @GetMapping("/{nome}")
    public ResponseEntity<EntityModel<Tag>> getTagByName(@PathVariable(name = "nome") String nome){
        return ResponseEntity.ok(service.getByName(nome));
    }



    @Operation(summary = "Criar uma nova Tag")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Tag criada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Tag.class))),
            @ApiResponse(responseCode = "400",description = "Input invalido",
                    content = @Content),
            @ApiResponse(responseCode = "400",description = "Input invalido",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<EntityModel<Tag>> createTag(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Tag to create", required = true,
                  content = @Content(mediaType = "application/json",
                  schema = @Schema(implementation = Tag.class),
            examples = @ExampleObject(value = "{ \"nomeTag\": }")))
        @RequestBody @Valid Tag novaTag){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(novaTag));

    }

    @Operation(summary = "Alterar uma Tag")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200",description = "Tag alterada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Tag.class))),//Input invalido
            @ApiResponse(responseCode = "201",description = "Tag criada com sucesso",
                    content = @Content),//Not Found
            @ApiResponse(responseCode = "400",description = "Input invalido",
                    content = @Content),//Input invalido
            @ApiResponse(responseCode = "409",description = "Tag já com esse nome ja existe",
                    content = @Content)//Input invalido
    })
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Tag>> updateTag(@PathVariable(name = "id") Long id,
                                         @RequestBody Tag updatedTag){
         return service.edit(updatedTag,id);
    }

    @Operation(summary = "Deletada uma Tag")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "204",description = "Tag deletada com sucesso",
                    content = @Content),
            @ApiResponse(responseCode = "404",description = "Tag not found",
                    content = @Content),//Not Found
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagById (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}



