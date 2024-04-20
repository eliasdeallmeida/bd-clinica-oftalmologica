package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.AtributoEstruturaLenteDAO;
import com.clinica_oftalmologica.model.AtributoEstruturaLente;
import com.clinica_oftalmologica.service.AtributoEstruturaLenteService;

public class AtributoEstruturaLenteTest {

    public static void main(String[] args) throws SQLException, ParseException {

        AtributoEstruturaLenteDAO atributoEstruturaLenteDAO = new AtributoEstruturaLenteDAO();
        AtributoEstruturaLenteService atributoEstruturaLenteService = new AtributoEstruturaLenteService();
        AtributoEstruturaLente atributoEstruturaLente = new AtributoEstruturaLente("CIL", "Direito");

        // Count
        System.out.println(atributoEstruturaLenteDAO.count());
        System.out.println();

        // Insert
        atributoEstruturaLenteService.insert(atributoEstruturaLente);
        System.out.println();

        // Select all
        List<AtributoEstruturaLente> atributoEstruturaLentes = atributoEstruturaLenteDAO.selectAll();
        atributoEstruturaLentes.forEach(System.out::println);
        System.out.println();

        // Select
        atributoEstruturaLente = atributoEstruturaLenteDAO.select(1);
        System.out.println(atributoEstruturaLente);
        System.out.println();

        // Update
        atributoEstruturaLente = atributoEstruturaLenteDAO.select(1);
        atributoEstruturaLente.setDescricao("CIL");
        atributoEstruturaLente.setLadoOlho("Esquerdo");
        atributoEstruturaLenteDAO.update(atributoEstruturaLente);
        atributoEstruturaLente = atributoEstruturaLenteDAO.select(1);
        System.out.println(atributoEstruturaLente);
        System.out.println();

        // Delete
        atributoEstruturaLenteDAO.delete(35);
        atributoEstruturaLenteDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
