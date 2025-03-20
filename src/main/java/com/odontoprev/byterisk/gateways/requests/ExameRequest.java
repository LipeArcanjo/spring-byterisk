package com.odontoprev.byterisk.gateways.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


/**
 * Classe que representa a requisição de um exame odontológico. Usada para agendar ou atualizar informações de exames.
 */
@Data
public class ExameRequest {

    @NotNull
    private Long idBeneficiario;

    @NotNull
    private LocalDate dataExame;

    private String tipoExame;

    private String resultadoExame;

    private Long idProfissional;
}
