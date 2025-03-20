package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

/**
 * Classe que representa a resposta com os dados de uma consulta. Usada para enviar as informações da consulta nas respostas da API.
 */
@Data
public class ConsultaResponse extends RepresentationModel<ConsultaResponse> {

    private Long idConsulta;
    private String nomeBeneficiario;
    private LocalDate dataConsulta;
    private String motivoConsulta;
    private String status;
    private String nomeProfissional;
}
