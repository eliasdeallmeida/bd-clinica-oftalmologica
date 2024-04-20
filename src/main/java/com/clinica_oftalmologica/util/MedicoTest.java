package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.MedicoDAO;
import com.clinica_oftalmologica.model.Medico;
import com.clinica_oftalmologica.service.MedicoService;

public class MedicoTest {

    public static void main(String[] args) throws SQLException, ParseException {

        MedicoDAO medicoDAO = new MedicoDAO();
        MedicoService medicoService = new MedicoService();
        Medico medico = new Medico("Fulano", "918237/CE");

        // Count
        System.out.println(medicoDAO.count());
        System.out.println();

        // Insert
        medicoService.insert(medico);
        System.out.println();

        // Select all
        List<Medico> medicos = medicoDAO.selectAll();
        medicos.forEach(System.out::println);
        System.out.println();

        // Select
        medico = medicoDAO.select(1);
        System.out.println(medico);
        System.out.println();

        // Update
        medico = medicoDAO.select(1);
        medico.setNome("Fulano de Tal");
        medico.setCrm("918237/CE");
        medicoDAO.update(medico);
        medico = medicoDAO.select(1);
        System.out.println(medico);
        System.out.println();

        // Delete
        medicoDAO.delete(35);
        medicoDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
