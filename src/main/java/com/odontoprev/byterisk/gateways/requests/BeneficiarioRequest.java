package com.odontoprev.byterisk.gateways.requests;

import com.odontoprev.byterisk.domains.enums.Ranking;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


/**
 * Classe que representa a requisição de um beneficiário. Usada para criar ou atualizar os
 * dados de um beneficiário.
 */
@Data
public class BeneficiarioRequest {

    private Long idBeneficiario;

    @NotBlank
    private String nome;

    private LocalDate dataNascimento;

    @NotBlank
    private String cpf;

    private String telefone;

    @Email
    private String email;

    private String endereco;

    @NotNull
    private Ranking ranking;

    @NotNull
    private Long idPlano;
}
