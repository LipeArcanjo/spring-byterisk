package com.odontoprev.byterisk.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExame;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario", nullable = false)
    private Beneficiario beneficiario;

    @Column(nullable = false)
    private LocalDate dataExame;

    private String tipoExame;

    private String resultadoExame;

    @ManyToOne
    @JoinColumn(name = "id_profissional")
    private Profissional profissional;
}
