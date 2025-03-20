package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Repositório para a entidade Profissional. Fornece métodos para realizar operações CRUD no banco de dados.
 */

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}
