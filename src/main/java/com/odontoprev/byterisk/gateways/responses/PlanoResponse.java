package com.odontoprev.byterisk.gateways.responses;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

/**
 * Classe que representa a resposta com os dados de um plano odontológico.
 * Usada para enviar as informações do plano nas respostas da API.
 */

@Data
public class PlanoResponse extends RepresentationModel<PlanoResponse> {

    private Long idPlano;
    private String nomePlano;
    private String tipoPlano;
    private Double valorMensal;
}
