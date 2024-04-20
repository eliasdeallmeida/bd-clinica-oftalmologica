package com.clinica_oftalmologica.util;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.PacienteDAO;
import com.clinica_oftalmologica.model.Paciente;
import com.clinica_oftalmologica.service.PacienteService;

public class PacienteTest {

    public static void main(String[] args) throws SQLException, ParseException {

        PacienteDAO pacienteDAO = new PacienteDAO();
        PacienteService pacienteService = new PacienteService();
        Paciente paciente = new Paciente("Cicrano", "98127397123", Date.valueOf("1999-12-02"));

        // Count
        System.out.println(pacienteDAO.count());
        System.out.println();

        // Insert
        pacienteService.insert(paciente);
        System.out.println();

        // Select all
        List<Paciente> pacientes = pacienteDAO.selectAll();
        pacientes.forEach(System.out::println);
        System.out.println();

        // Select
        paciente = pacienteDAO.select(1);
        System.out.println(paciente);
        System.out.println();

        // Update
        paciente = pacienteDAO.select(1);
        paciente.setNome("Cicrano");
        paciente.setCpf("12345678900");
        paciente.setDataNascimento(Date.valueOf("1999-12-01"));
        pacienteDAO.update(paciente);
        paciente = pacienteDAO.select(1);
        System.out.println(paciente);
        System.out.println();

        // Delete
        pacienteDAO.delete(35);
        pacienteDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
