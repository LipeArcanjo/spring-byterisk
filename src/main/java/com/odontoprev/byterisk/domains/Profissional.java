package com.odontoprev.byterisk.domains;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Profissional")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfissional;

    @Column(nullable = false)
    private String nome;

    private String especialidade;

    @Column(unique = true, nullable = false)
    private String crm;

}
