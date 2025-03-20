package com.odontoprev.byterisk.domains;

import com.odontoprev.byterisk.domains.enums.StatusConsulta;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario", nullable = false)
    private Beneficiario beneficiario;

    @Column(nullable = false)
    private LocalDate dataConsulta;

    private String motivoConsulta;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;

}
