package com.odontoprev.byterisk.gateways.controllers;

import com.odontoprev.byterisk.domains.Beneficiario;
import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import com.odontoprev.byterisk.usecases.interfaces.BeneficiarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerenciar operações relacionadas a beneficiários.
 * Fornece endpoints para criar, atualizar, buscar e deletar beneficiários.
 */

@RestController
@RequestMapping("/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;


    /**
     * Endpoint para criar um novo beneficiário.
     *
     * @param request dados do beneficiário a ser criado
     * @return resposta contendo o beneficiário criado e o status HTTP 201
     */
    @PostMapping
    public ResponseEntity<BeneficiarioResponse> criarBeneficiario(@Valid @RequestBody BeneficiarioRequest request){
        BeneficiarioResponse response = beneficiarioService.criarBeneficiario(request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * Endpoint para atualizar um beneficiário existente.
     *
     * @param id ID do beneficiário a ser atualizado
     * @param request dados atualizados do beneficiário
     * @return resposta contendo o beneficiário atualizado e o status HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioResponse> atualizarBeneficiario(@PathVariable Long id, @Valid @RequestBody BeneficiarioRequest request) {
        BeneficiarioResponse response = beneficiarioService.atualizarBeneficiario(id, request);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * Endpoint para buscar um beneficiário pelo ID.
     *
     * @param id ID do beneficiário
     * @return resposta contendo o beneficiário encontrado e o status HTTP 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioResponse> buscarBeneficiarioPorId(@PathVariable Long id) {
        BeneficiarioResponse response = beneficiarioService.buscarBeneficiarioPorId(id);
        addHateoasLinks(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * Endpoint para buscar todos os beneficiários.
     *
     * @return lista de beneficiários e o status HTTP 200
     */
    @GetMapping()
    public ResponseEntity<List<BeneficiarioResponse>> buscarBeneficiarios() {
        List<BeneficiarioResponse> response = beneficiarioService.buscarBeneficiarios();
        response.forEach(this::addHateoasLinks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /**
     * Endpoint para deletar um beneficiário pelo ID.
     *
     * @param id ID do beneficiário a ser deletado
     * @return status HTTP 204 (sem conteúdo)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBeneficiario(@PathVariable Long id) {
        beneficiarioService.deletarBeneficiario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private void addHateoasLinks(BeneficiarioResponse response) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BeneficiarioController.class)
                .buscarBeneficiarioPorId(response.getIdBeneficiario())).withSelfRel();
        Link addBeneficiarioLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BeneficiarioController.class)
                .buscarBeneficiarios()).withRel("all-beneficiarios");

        response.add(selfLink);
        response.add(addBeneficiarioLink);
    }
}
