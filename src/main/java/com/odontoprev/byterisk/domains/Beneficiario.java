package com.odontoprev.byterisk.domains;

import com.odontoprev.byterisk.domains.enums.Ranking;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Beneficiario")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBeneficiario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    private String email;

    private String endereco;

    @Enumerated(EnumType.STRING)
    @Column(length = 2)
    private Ranking ranking;

    @ManyToOne
    @JoinColumn(name = "id_plano", nullable = false)
    private Plano plano;

}
