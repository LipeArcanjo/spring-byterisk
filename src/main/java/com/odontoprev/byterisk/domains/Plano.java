package com.odontoprev.byterisk.domains;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Plano")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlano;

    @Column(nullable = false)
    private String nomePlano;

    @Column(nullable = false)
    private String tipoPlano;

    @Column(nullable = false)
    private Double valorMensal;

}
