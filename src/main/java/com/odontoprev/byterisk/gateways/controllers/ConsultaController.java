package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.ConsultaRequest;
import com.odontoprev.byterisk.gateways.responses.ConsultaResponse;
import com.odontoprev.byterisk.usecases.interfaces.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar operações relacionadas às consultas odontológicas.
 * Fornece endpoints para criar, atualizar, buscar e deletar consultas.
 */

@RestController
@RequestMapping("/consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    /**
     * Endpoint para criar uma nova consulta.
     *
     * @param request dados da consulta a ser criada
     * @return resposta contendo a consulta criada e o status HTTP 201
     */
    @PostMapping
    public ResponseEntity<ConsultaResponse> criarConsulta(@Valid @RequestBody ConsultaRequest request) {
        ConsultaResponse response = consultaService.criarConsulta(request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * Endpoint para atualizar uma consulta existente.
     *
     * @param id ID da consulta a ser atualizada
     * @param request dados atualizados da consulta
     * @return resposta contendo a consulta atualizada e o status HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> atualizarConsulta(@PathVariable Long id, @Valid @RequestBody ConsultaRequest request) {
        ConsultaResponse response = consultaService.atualizarConsulta(id, request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar uma consulta pelo ID.
     *
     * @param id ID da consulta
     * @return resposta contendo a consulta encontrada e o status HTTP 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarConsultaPorId(@PathVariable Long id) {
        ConsultaResponse response = consultaService.buscarConsultaPorId(id);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar todas as consultas.
     *
     * @return lista de consultas e o status HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> buscarConsultas() {
        List<ConsultaResponse> response = consultaService.buscarConsultas();
        response.forEach(this::addHateoasLinks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para deletar uma consulta pelo ID.
     *
     * @param id ID da consulta a ser deletada
     * @return status HTTP 204 (sem conteúdo)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Adiciona links HATEOAS para um objeto ConsultaResponse.
     *
     * @param response objeto ConsultaResponse a ser modificado com links HATEOAS
     */
    private void addHateoasLinks(ConsultaResponse response) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class)
                .buscarConsultaPorId(response.getIdConsulta())).withSelfRel();
        Link allConsultasLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsultaController.class)
                .buscarConsultas()).withRel("all-consultas");

        response.add(selfLink);
        response.add(allConsultasLink);
    }
}
