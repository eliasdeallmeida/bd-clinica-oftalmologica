package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.EspecificacaoLenteDAO;
import com.clinica_oftalmologica.model.EspecificacaoLente;
import com.clinica_oftalmologica.service.EspecificacaoLenteService;

public class EspecificacaoLenteTest {

    public static void main(String[] args) throws SQLException, ParseException {

        EspecificacaoLenteDAO especificacaoLenteDAO = new EspecificacaoLenteDAO();
        EspecificacaoLenteService especificacaoLenteService = new EspecificacaoLenteService();
        EspecificacaoLente especificacaoLente = new EspecificacaoLente(25.50f, 1, 1);

        // Count
        System.out.println(especificacaoLenteDAO.count());
        System.out.println();

        // Insert
        especificacaoLenteService.insert(especificacaoLente);
        System.out.println();

        // Select all
        List<EspecificacaoLente> especificacaoLentes = especificacaoLenteDAO.selectAll();
        especificacaoLentes.forEach(System.out::println);
        System.out.println();

        // Select
        especificacaoLente = especificacaoLenteDAO.select(2);
        System.out.println(especificacaoLente);
        System.out.println();

        // Update
        especificacaoLente = especificacaoLenteDAO.select(2);
        especificacaoLente.setValor(25.0f);
        especificacaoLente.setIdEstruturaLente(1);
        especificacaoLente.setIdAtributoEstruturaLente(1);
        especificacaoLenteDAO.update(especificacaoLente);
        especificacaoLente = especificacaoLenteDAO.select(2);
        System.out.println(especificacaoLente);
        System.out.println();

        // Delete
        especificacaoLenteDAO.delete(35);
        especificacaoLenteDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
