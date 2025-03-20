package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.ExameRequest;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import com.odontoprev.byterisk.usecases.interfaces.ExameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar operações relacionadas aos exames odontológicos.
 * Fornece endpoints para criar, atualizar, buscar e deletar exames.
 */

@RestController
@RequestMapping("/exame")
@RequiredArgsConstructor
public class ExameController {

    private final ExameService exameService;

    /**
     * Endpoint para criar um novo exame.
     *
     * @param request dados do exame a ser criado
     * @return resposta contendo o exame criado e o status HTTP 201
     */
    @PostMapping
    public ResponseEntity<ExameResponse> criarExame(@Valid @RequestBody ExameRequest request) {
        ExameResponse response = exameService.criarExame(request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Endpoint para atualizar um exame existente.
     *
     * @param id ID do exame a ser atualizado
     * @param request dados atualizados do exame
     * @return resposta contendo o exame atualizado e o status HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<ExameResponse> atualizarExame(@PathVariable Long id, @Valid @RequestBody ExameRequest request) {
        ExameResponse response = exameService.atualizarExame(id, request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar um exame pelo ID.
     *
     * @param id ID do exame
     * @return resposta contendo o exame encontrado e o status HTTP 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<ExameResponse> buscarExamePorId(@PathVariable Long id) {
        ExameResponse response = exameService.buscarExamePorId(id);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar todos os exames.
     *
     * @return resposta contendo a lista de exames e o status HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<ExameResponse>> buscarExames() {
        List<ExameResponse> response = exameService.buscarExames();
        response.forEach(this::addHateoasLinks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para deletar um exame.
     *
     * @param id ID do exame a ser deletado
     * @return status HTTP 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExame(@PathVariable Long id) {
        exameService.deletarExame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Adiciona links HATEOAS a um objeto ExameResponse.
     *
     * @param response objeto ExameResponse a ser modificado com links HATEOAS
     */
    private void addHateoasLinks(ExameResponse response) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExameController.class)
                .buscarExamePorId(response.getIdExame())).withSelfRel();
        Link allExamesLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExameController.class)
                .buscarExames()).withRel("all-exames");

        response.add(selfLink);
        response.add(allExamesLink);
    }
}
