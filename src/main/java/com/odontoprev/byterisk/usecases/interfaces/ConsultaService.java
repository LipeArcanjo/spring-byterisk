package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.ConsultaRequest;
import com.odontoprev.byterisk.gateways.responses.ConsultaResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define os serviços relacionados aos beneficiários.
 * Contém os métodos para criar, atualizar, buscar e deletar beneficiários.
 */
@Service
public interface ConsultaService {


    /**
     * Cria um novo beneficiário com os dados fornecidos.
     *
     * @param request dados do beneficiário a ser criado
     * @return o beneficiário criado como resposta
     */
    ConsultaResponse criarConsulta(ConsultaRequest request);

    /**
     * Atualiza um beneficiário existente com os novos dados fornecidos.
     *
     * @param id ID do beneficiário a ser atualizado
     * @param request dados atualizados do beneficiário
     * @return o beneficiário atualizado como resposta
     */
    ConsultaResponse atualizarConsulta(Long id,ConsultaRequest request);

    /**
     * Busca um beneficiário pelo ID.
     *
     * @param id ID do beneficiário
     * @return o beneficiário encontrado como resposta
     */
    ConsultaResponse buscarConsultaPorId(Long id);

    /**
     * Retorna uma lista com todos os beneficiários cadastrados.
     *
     * @return lista de beneficiários como resposta
     */
    List<ConsultaResponse> buscarConsultas();

    /**
     * Deleta uma consulta pelo ID.
     *
     * @param id ID da consulta a ser deletada
     */
    void deletarConsulta(Long id);
}
