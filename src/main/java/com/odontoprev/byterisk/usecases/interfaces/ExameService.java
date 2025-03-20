package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.ExameRequest;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define os serviços relacionados aos exames odontológicos.
 * Contém os métodos para criar, atualizar, buscar e deletar exames.
 */
@Service
public interface ExameService {

    /**
     * Cria um novo exame com os dados fornecidos.
     *
     * @param request dados do exame a ser criado
     * @return o exame criado como resposta
     */
    ExameResponse criarExame(ExameRequest request);

    /**
     * Atualiza um exame existente com os novos dados fornecidos.
     *
     * @param id ID do exame a ser atualizado
     * @param request dados atualizados do exame
     * @return o exame atualizado como resposta
     */
    ExameResponse atualizarExame(Long id,ExameRequest request);

    /**
     * Busca um exame pelo ID.
     *
     * @param id ID do exame
     * @return o exame encontrado como resposta
     */
    ExameResponse buscarExamePorId(Long id);

    /**
     * Retorna uma lista com todos os exames cadastrados.
     *
     * @return lista de exames como resposta
     */
    List<ExameResponse> buscarExames();

    /**
     * Deleta um exame pelo ID.
     *
     * @param id ID do exame a ser deletado
     */
    void deletarExame(Long id);
}
