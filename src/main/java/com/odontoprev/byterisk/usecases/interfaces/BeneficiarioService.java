package com.odontoprev.byterisk.usecases.interfaces;


import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define os serviços relacionados aos beneficiários.
 * Contém os métodos para criar, atualizar, buscar e deletar beneficiários.
 */

@Service
public interface BeneficiarioService {

    /**
     * Cria um novo beneficiário com os dados fornecidos.
     *
     * @param request dados do beneficiário a ser criado
     * @return o beneficiário criado como resposta
     */
    BeneficiarioResponse criarBeneficiario(BeneficiarioRequest request);

    /**
     * Atualiza um beneficiário existente com os novos dados fornecidos.
     *
     * @param id ID do beneficiário a ser atualizado
     * @param request dados atualizados do beneficiário
     * @return o beneficiário atualizado como resposta
     */
    BeneficiarioResponse atualizarBeneficiario(Long id,BeneficiarioRequest request);

    /**
     * Busca um beneficiário pelo ID.
     *
     * @param id ID do beneficiário
     * @return o beneficiário encontrado como resposta
     */
    BeneficiarioResponse buscarBeneficiarioPorId(Long id);

    /**
     * Retorna uma lista com todos os beneficiários cadastrados.
     *
     * @return lista de beneficiários como resposta
     */
    List<BeneficiarioResponse> buscarBeneficiarios();

    /**
     * Deleta um beneficiário pelo ID.
     *
     * @param id ID do beneficiário a ser deletado
     */
    void deletarBeneficiario(Long id);
}
