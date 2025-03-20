package com.odontoprev.byterisk.gateways.requests;

import com.odontoprev.byterisk.domains.enums.TipoSinistro;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * Classe que representa a requisição de um sinistro odontológico. Usada para registrar ou
 * atualizar informações de sinistros.
 */
@Data
public class SinistroRequest {

    @NotNull
    private Long idBeneficiario;

    @NotNull
    private LocalDate dataSinistro;

    @NotNull
    private TipoSinistro tipoSinistro;

    private Double valorSinistro;
}
