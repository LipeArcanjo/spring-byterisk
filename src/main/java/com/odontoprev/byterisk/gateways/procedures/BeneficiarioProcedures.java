package com.odontoprev.byterisk.gateways.procedures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class BeneficiarioProcedures {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BeneficiarioProcedures(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inserirBeneficiario(String nome, Date dataNascimento, String cpf, String telefone, String email, String endereco, String ranking, Long idPlano) {
        String sql = "{call pkg_crud.inserir_beneficiario(?, ?, ?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, nome, dataNascimento, cpf, telefone, email, endereco, ranking, idPlano);
    }

    public void atualizarBeneficiario(Long idBeneficiario, String nome, Date dataNascimento, String cpf, String telefone, String email, String endereco, String ranking, Long idPlano) {
        String sql = "{call pkg_crud.atualizar_beneficiario(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        jdbcTemplate.update(sql, idBeneficiario, nome, dataNascimento, cpf, telefone, email, endereco, ranking, idPlano);
    }

    public void deletarBeneficiario(Long idBeneficiario) {
        String sql = "{call deletar_beneficiario(?)}";
        jdbcTemplate.update(sql, idBeneficiario);
    }
}