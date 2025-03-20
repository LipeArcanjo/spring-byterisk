package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.gateways.requests.PlanoRequest;
import com.odontoprev.byterisk.gateways.responses.PlanoResponse;
import com.odontoprev.byterisk.usecases.interfaces.PlanoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar operações relacionadas a planos odontológicos.
 * Fornece endpoints para criar, atualizar, buscar e deletar planos.
 */

@RestController
@RequestMapping("/plano")
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoService planoService;

    /**
     * Endpoint para criar um novo plano.
     *
     * @param request dados do plano a ser criado
     * @return resposta contendo o plano criado e o status HTTP 201
     */
    @PostMapping
    public ResponseEntity<PlanoResponse> criarPlano(@Valid @RequestBody PlanoRequest request) {
        PlanoResponse response = planoService.criarPlano(request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Endpoint para atualizar um plano existente.
     *
     * @param id ID do plano a ser atualizado
     * @param request dados atualizados do plano
     * @return resposta contendo o plano atualizado e o status HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<PlanoResponse> atualizarPlano(@PathVariable Long id, @Valid @RequestBody PlanoRequest request) {
        PlanoResponse response = planoService.atualizarPlano(id, request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar um plano pelo ID.
     *
     * @param id ID do plano
     * @return resposta contendo o plano encontrado e o status HTTP 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlanoResponse> buscarPlanoPorId(@PathVariable Long id) {
        PlanoResponse response = planoService.buscarPlanoPorId(id);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para buscar todos os planos.
     *
     * @return resposta contendo a lista de planos e o status HTTP 200
     */
    @GetMapping
    public ResponseEntity<List<PlanoResponse>> buscarPlanos() {
        List<PlanoResponse> response = planoService.buscarPlanos();
        response.forEach(this::addHateoasLinks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Endpoint para deletar um plano pelo ID.
     *
     * @param id ID do plano
     * @return status HTTP 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
            * Adiciona links HATEOAS a um objeto PlanoResponse.
     *
             * @param response objeto PlanoResponse a ser modificado com links HATEOAS
     */
    private void addHateoasLinks(PlanoResponse response) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlanoController.class)
                .buscarPlanoPorId(response.getIdPlano())).withSelfRel();
        Link allPlanosLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlanoController.class)
                .buscarPlanos()).withRel("all-planos");

        response.add(selfLink);
        response.add(allPlanosLink);
    }
}
