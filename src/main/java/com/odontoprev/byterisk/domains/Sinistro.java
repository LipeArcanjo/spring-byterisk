package com.odontoprev.byterisk.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Sinistro")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSinistro;

    @ManyToOne
    @JoinColumn(name = "id_beneficiario", nullable = false)
    private Beneficiario beneficiario;

    @Column(nullable = false)
    private LocalDate dataSinistro;

    private String tipoSinistro;

    private Double valorSinistro;
}
