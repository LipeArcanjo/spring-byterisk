package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.PlanoRequest;
import com.odontoprev.byterisk.gateways.responses.PlanoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define os serviços relacionados aos planos odontológicos.
 * Contém os métodos para criar, atualizar, buscar e deletar planos.
 */
@Service
public interface PlanoService {

    /**
     * Cria um novo plano com os dados fornecidos.
     *
     * @param request dados do plano a ser criado
     * @return o plano criado como resposta
     */
    PlanoResponse criarPlano(PlanoRequest request);

    /**
     * Atualiza um plano existente com os novos dados fornecidos.
     *
     * @param id ID do plano a ser atualizado
     * @param request dados atualizados do plano
     * @return o plano atualizado como resposta
     */
    PlanoResponse atualizarPlano(Long id,PlanoRequest request);

    /**
     * Busca um plano pelo ID.
     *
     * @param id ID do plano
     * @return o plano encontrado como resposta
     */
    PlanoResponse buscarPlanoPorId(Long id);

    /**
     * Retorna uma lista com todos os planos cadastrados.
     *
     * @return lista de planos como resposta
     */
    List<PlanoResponse> buscarPlanos();

    /**
     * Deleta um plano pelo ID.
     *
     * @param id ID do plano a ser deletado
     */
    void deletarPlano(Long id);
}
