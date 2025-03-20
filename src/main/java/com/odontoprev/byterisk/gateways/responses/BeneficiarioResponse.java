package com.odontoprev.byterisk.gateways.responses;

import com.odontoprev.byterisk.domains.enums.Ranking;
import lombok.Data;
import oracle.jdbc.driver.Representation;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

/**
 * Classe que representa a resposta com os dados de um beneficiário. Usada para enviar as informações
 * do beneficiário nas respostas da API.
 */
@Data
public class BeneficiarioResponse extends RepresentationModel<BeneficiarioResponse> {

    private Long idBeneficiario;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private Ranking ranking;
    private String nomePlano;
    private LocalDate dataNascimento;
    private Long idPlano;
}
