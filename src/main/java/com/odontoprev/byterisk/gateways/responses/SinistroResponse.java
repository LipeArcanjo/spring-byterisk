package com.odontoprev.byterisk.gateways.responses;


import com.odontoprev.byterisk.domains.enums.TipoSinistro;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

/**
 * Classe que representa a resposta com os dados de um sinistro odontológico. Usada para enviar
 * as informações do sinistro nas respostas da API.
 */

@Data
public class SinistroResponse extends RepresentationModel<SinistroResponse> {

    private Long idSinistro;
    private String nomeBeneficiario;
    private LocalDate dataSinistro;
    private TipoSinistro tipoSinistro;
    private Double valorSinistro;
}
