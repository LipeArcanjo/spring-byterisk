package com.odontoprev.byterisk.usecases.interfaces;

import com.odontoprev.byterisk.gateways.requests.SinistroRequest;
import com.odontoprev.byterisk.gateways.responses.SinistroResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define os serviços relacionados aos sinistros odontológicos.
 * Contém os métodos para criar, atualizar, buscar e deletar sinistros.
 */
@Service
public interface SinistroService {

    /**
     * Cria um novo sinistro com os dados fornecidos.
     *
     * @param request dados do sinistro a ser criado
     * @return o sinistro criado como resposta
     */
    SinistroResponse criarSinistro(SinistroRequest request);

    /**
     * Atualiza um sinistro existente com os novos dados fornecidos.
     *
     * @param id ID do sinistro a ser atualizado
     * @param request dados atualizados do sinistro
     * @return o sinistro atualizado como resposta
     */
    SinistroResponse atualizarSinistro(Long id,SinistroRequest request);

    /**
     * Busca um sinistro pelo ID.
     *
     * @param id ID do sinistro
     * @return o sinistro encontrado como resposta
     */
    SinistroResponse buscarSinistroPorId(Long id);

    /**
     * Retorna uma lista com todos os sinistros cadastrados.
     *
     * @return lista de sinistros como resposta
     */
    List<SinistroResponse> buscarSinistros();

    /**
     * Deleta um sinistro pelo ID.
     *
     * @param id ID do sinistro a ser deletado
     */

    void deletarSinistro(Long id);
}
