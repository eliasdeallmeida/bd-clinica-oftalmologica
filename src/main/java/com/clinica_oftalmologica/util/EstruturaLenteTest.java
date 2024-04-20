package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.EstruturaLenteDAO;
import com.clinica_oftalmologica.model.EstruturaLente;
import com.clinica_oftalmologica.service.EstruturaLenteService;

public class EstruturaLenteTest {

    public static void main(String[] args) throws SQLException, ParseException {

        EstruturaLenteDAO estruturaLenteDAO = new EstruturaLenteDAO();
        EstruturaLenteService estruturaLenteService = new EstruturaLenteService();
        EstruturaLente estruturaLente = new EstruturaLente("CIL", 12, 1);

        // Count
        System.out.println(estruturaLenteDAO.count());
        System.out.println();

        // Insert
        estruturaLenteService.insert(estruturaLente);
        System.out.println();

        // Select all
        List<EstruturaLente> estruturaLentes = estruturaLenteDAO.selectAll();
        estruturaLentes.forEach(System.out::println);
        System.out.println();

        // Select
        estruturaLente = estruturaLenteDAO.select(1);
        System.out.println(estruturaLente);
        System.out.println();

        // Update
        estruturaLente = estruturaLenteDAO.select(1);
        estruturaLente.setTipoCorrecao("EIXO");
        estruturaLente.setDistanciaPupilar(10);
        // estruturaLente.setIdReceitaOculos(2);
        estruturaLenteDAO.update(estruturaLente);
        estruturaLente = estruturaLenteDAO.select(1);
        System.out.println(estruturaLente);
        System.out.println();

        // Delete
        estruturaLenteDAO.delete(35);
        estruturaLenteDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
