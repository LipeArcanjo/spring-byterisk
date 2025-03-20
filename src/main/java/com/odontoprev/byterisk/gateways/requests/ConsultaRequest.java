package com.odontoprev.byterisk.gateways.requests;

import com.odontoprev.byterisk.domains.enums.StatusConsulta;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


/**
 * Classe que representa a requisição de uma consulta odontológica. Usada para agendar ou atualizar consultas.
 */
@Data
public class ConsultaRequest {

    @NotNull
    private Long idBeneficiario;

    @NotNull
    private LocalDate dataConsulta;

    private String motivoConsulta;

    @NotNull
    private StatusConsulta status;

    private Long idProfissional;
}
