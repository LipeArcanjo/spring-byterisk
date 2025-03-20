package com.odontoprev.byterisk.usecases.impl;

import com.odontoprev.byterisk.domains.Consulta;
import com.odontoprev.byterisk.gateways.repositories.BeneficiarioRepository;
import com.odontoprev.byterisk.gateways.repositories.ConsultaRepository;
import com.odontoprev.byterisk.gateways.repositories.ProfissionalRepository;
import com.odontoprev.byterisk.gateways.requests.ConsultaRequest;
import com.odontoprev.byterisk.gateways.responses.ConsultaResponse;
import com.odontoprev.byterisk.usecases.interfaces.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementação do serviço de Consulta. Contém a lógica para criar, atualizar, buscar e deletar consultas.
 */
@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final ProfissionalRepository profissionalRepository;

    /**
     * Cria uma nova consulta com os dados fornecidos na requisição.
     *
     * @param request dados da nova consulta
     * @return a consulta criada como resposta
     */
    @Override
    public ConsultaResponse criarConsulta(ConsultaRequest request) {
        Consulta consulta = new Consulta();
        consulta.setBeneficiario(beneficiarioRepository.findById(request.getIdBeneficiario())
                .orElseThrow());
        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setMotivoConsulta(request.getMotivoConsulta());
        consulta.setStatus(request.getStatus());
        consulta.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                .orElseThrow());

        Consulta salvo = consultaRepository.save(consulta);
        return mapToResponse(salvo);
    }

    /**
     * Atualiza uma consulta existente com os novos dados fornecidos.
     *
     * @param id ID da consulta a ser atualizada
     * @param request dados atualizados da consulta
     * @return a consulta atualizada como resposta
     */
    @Override
    public ConsultaResponse atualizarConsulta(Long id, ConsultaRequest request) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();

        consulta.setDataConsulta(request.getDataConsulta());
        consulta.setMotivoConsulta(request.getMotivoConsulta());
        consulta.setStatus(request.getStatus());

        consulta.setProfissional(profissionalRepository.findById(request.getIdProfissional())
                .orElseThrow());

        Consulta atualizado = consultaRepository.save(consulta);
        return mapToResponse(atualizado);
    }

    /**
     * Busca uma consulta pelo ID.
     *
     * @param id ID da consulta
     * @return a consulta encontrada como resposta
     */
    @Override
    public ConsultaResponse buscarConsultaPorId(Long id) {
        Consulta consultaId = consultaRepository.findById(id).orElseThrow();
        return mapToResponse(consultaId);
    }

    /**
     * Busca todas as consultas.
     *
     * @return lista de consultas como resposta
     */
    @Override
    public List<ConsultaResponse> buscarConsultas() {
        return consultaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    /**
     * Deleta uma consulta pelo ID.
     *
     * @param id ID da consulta a ser deletada
     */
    @Override
    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    /**
     * Mapeia a entidade Consulta para ConsultaResponse.
     *
     * @param consulta a consulta a ser mapeada
     * @return o objeto ConsultaResponse correspondente
     */
    private ConsultaResponse mapToResponse(Consulta consulta) {
        ConsultaResponse response = new ConsultaResponse();
        response.setIdConsulta(consulta.getIdConsulta());
        response.setNomeBeneficiario(consulta.getBeneficiario().getNome());
        response.setDataConsulta(consulta.getDataConsulta());
        response.setMotivoConsulta(consulta.getMotivoConsulta());
        response.setStatus(String.valueOf(consulta.getStatus()));
        response.setNomeProfissional(consulta.getProfissional().getNome());

        return response;
    }
}
