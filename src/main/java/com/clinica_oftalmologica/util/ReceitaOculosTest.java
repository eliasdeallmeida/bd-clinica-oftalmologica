package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.ReceitaOculosDAO;
import com.clinica_oftalmologica.model.ReceitaOculos;
import com.clinica_oftalmologica.service.ReceitaOculosService;

public class ReceitaOculosTest {

    public static void main(String[] args) throws SQLException, ParseException {

        ReceitaOculosDAO receitaOculosDAO = new ReceitaOculosDAO();
        ReceitaOculosService receitaOculosService = new ReceitaOculosService();
        ReceitaOculos receitaOculos = new ReceitaOculos(1);
        // ReceitaOculos receitaOculos = new ReceitaOculos("Detalhamento", 1);

        // Count
        System.out.println(receitaOculosDAO.count());
        System.out.println();

        // Insert
        receitaOculosService.insert(receitaOculos);
        System.out.println();

        // Select all
        List<ReceitaOculos> receitaOculoss = receitaOculosDAO.selectAll();
        receitaOculoss.forEach(System.out::println);
        System.out.println();

        // Select
        receitaOculos = receitaOculosDAO.select(2);
        System.out.println(receitaOculos);
        System.out.println();

        // Update
        receitaOculos = receitaOculosDAO.select(1);
        receitaOculos.setDetalhamento("Detalhamento 1");
        receitaOculos.setIdConsultaMedica(1);
        receitaOculosDAO.update(receitaOculos);
        receitaOculos = receitaOculosDAO.select(1);
        System.out.println(receitaOculos);
        System.out.println();

        // Delete
        receitaOculosDAO.delete(35);
        receitaOculosDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
