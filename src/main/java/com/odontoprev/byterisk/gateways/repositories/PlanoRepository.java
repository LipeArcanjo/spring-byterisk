package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositório para a entidade Plano. Fornece métodos para realizar operações CRUD no banco de dados.
 */


public interface PlanoRepository extends JpaRepository<Plano, Long> {
    Optional<Plano> findFirstByNomePlanoOrderByIdPlanoDesc(String nomePlano);

}
