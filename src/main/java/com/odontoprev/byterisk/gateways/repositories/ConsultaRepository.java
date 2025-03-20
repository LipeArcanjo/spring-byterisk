package com.odontoprev.byterisk.gateways.repositories;

import com.odontoprev.byterisk.domains.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para a entidade Consulta. Fornece métodos para realizar operações CRUD no banco de dados.
 */
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
