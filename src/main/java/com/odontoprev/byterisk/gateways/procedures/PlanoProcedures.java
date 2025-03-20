package com.odontoprev.byterisk.gateways.procedures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlanoProcedures {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlanoProcedures(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inserirPlano(String nomePlano, String tipoPlano, Double valorMensal) {
        String sql = "{call inserir_plano(?, ?, ?)}";
        jdbcTemplate.update(sql, nomePlano, tipoPlano, valorMensal);
    }

    public void atualizarPlano(Long idPlano, String nomePlano, String tipoPlano, Double valorMensal) {
        String sql = "{call atualizar_plano(?, ?, ?, ?)}";
        jdbcTemplate.update(sql, idPlano, nomePlano, tipoPlano, valorMensal);
    }


    public void deletarPlano(Long idPlano) {
        String sql = "{call deletar_plano(?)}";
        jdbcTemplate.update(sql, idPlano);
    }
}
