package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Exame;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.ExameRepository;
import com.odontoprev.byterisk.gateways.repositories.ProfissionalRepository;
import com.odontoprev.byterisk.gateways.requests.ExameRequest;
import com.odontoprev.byterisk.gateways.responses.ExameResponse;
import com.odontoprev.byterisk.usecases.interfaces.ExameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de Exame. Contém a lógica para criar, atualizar, buscar e deletar exames.
 */

@Service
@RequiredArgsConstructor
public class ExameServiceImpl implements ExameService {

    private final ExameRepository exameRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ProfissionalRepository profissionalRepository;

    /**
     * Cria um novo exame com os dados fornecidos na requisição.
     *
     * @param request dados do novo exame
     * @return o exame criado como resposta
     */
    @Override
    public ExameResponse criarExame(ExameRequest request) {
        Exame exame = new Exame();
        exame.setBeneficiario(beneficiarioRepository.findById(request.getIdBeneficiario())
                .orElseThrow(() -> new RuntimeException("Beneficiário não encontrado!")));
        exame.setDataExame(request.getDataExame());
        exame.setTipoExame(request.getTipoExame());
        exame.setResultadoExame(request.getResultadoExame());
        if (request.getIdProfissional() != null) {
            exame.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                    .orElseThrow(() -> new RuntimeException("Profissional não encontrado!")));
        }

        Exame salvo = exameRepository.save(exame);
        return mapToResponse(salvo);
    }

    /**
     * Atualiza um exame existente com os novos dados fornecidos.
     *
     * @param id ID do exame a ser atualizado
     * @param request dados atualizados do exame
     * @return o exame atualizado como resposta
     */
    @Override
    public ExameResponse atualizarExame(Long id, ExameRequest request) {
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado!"));

        exame.setDataExame(request.getDataExame());
        exame.setTipoExame(request.getTipoExame());
        exame.setResultadoExame(request.getResultadoExame());

        if (request.getIdProfissional() != null) {
            exame.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                    .orElseThrow(() -> new RuntimeException("Profissional não encontrado!")));
        }

        Exame atualizado = exameRepository.save(exame);
        return mapToResponse(atualizado);
    }

    /**
     * Busca um exame pelo ID.
     *
     * @param id ID do exame
     * @return o exame encontrado como resposta
     */
    @Override
    public ExameResponse buscarExamePorId(Long id) {
        Exame exame = exameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado!"));
        return mapToResponse(exame);
    }

    /**
     * Retorna uma lista com todos os exames cadastrados.
     *
     * @return lista de exames como resposta
     */
    @Override
    public List<ExameResponse> buscarExames() {
        return exameRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Deleta um exame pelo ID.
     *
     * @param id ID do exame a ser deletado
     */
    @Override
    public void deletarExame(Long id) {
        exameRepository.deleteById(id);
    }

    /**
     * Mapeia a entidade Exame para ExameResponse.
     *
     * @param exame o exame a ser mapeado
     * @return o objeto ExameResponse correspondente
     */
    private ExameResponse mapToResponse(Exame exame) {
        ExameResponse response = new ExameResponse();
        response.setIdExame(exame.getIdExame());
        response.setNomeBeneficiario(exame.getBeneficiario().getNome());
        response.setDataExame(exame.getDataExame());
        response.setTipoExame(exame.getTipoExame());
        response.setResultadoExame(exame.getResultadoExame());
        response.setNomeProfissional(exame.getProfissional().getNome());


        return response;
    }
}
