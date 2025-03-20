package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Exame. Fornece métodos para realizar operações CRUD no banco de dados.
 */

public interface ExameRepository extends JpaRepository<Exame, Long> {
}
