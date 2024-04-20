package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.ObservacaoLaudoDAO;
import com.clinica_oftalmologica.model.ObservacaoLaudo;
import com.clinica_oftalmologica.service.ObservacaoLaudoService;

public class ObservacaoLaudoTest {

    public static void main(String[] args) throws SQLException, ParseException {

        ObservacaoLaudoDAO observacaoLaudoDAO = new ObservacaoLaudoDAO();
        ObservacaoLaudoService observacaoLaudoService = new ObservacaoLaudoService();
        ObservacaoLaudo observacaoLaudo = new ObservacaoLaudo("Descrição", 1);

        // Count
        System.out.println(observacaoLaudoDAO.count());
        System.out.println();

        // Insert
        observacaoLaudoService.insert(observacaoLaudo);
        System.out.println();

        // Select all
        List<ObservacaoLaudo> observacaoLaudos = observacaoLaudoDAO.selectAll();
        observacaoLaudos.forEach(System.out::println);
        System.out.println();

        // Select
        observacaoLaudo = observacaoLaudoDAO.select(1);
        System.out.println(observacaoLaudo);
        System.out.println();

        // Update
        observacaoLaudo = observacaoLaudoDAO.select(1);
        observacaoLaudo.setDescricao("Descrição 1");
        observacaoLaudo.setIdReceitaOculos(1);
        observacaoLaudoDAO.update(observacaoLaudo);
        observacaoLaudo = observacaoLaudoDAO.select(1);
        System.out.println(observacaoLaudo);
        System.out.println();

        // Delete
        observacaoLaudoDAO.delete(35);
        observacaoLaudoDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
