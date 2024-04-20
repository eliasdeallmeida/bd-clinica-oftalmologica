package com.clinica_oftalmologica.util;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.ConsultaMedicaDAO;
import com.clinica_oftalmologica.model.ConsultaMedica;
import com.clinica_oftalmologica.service.ConsultaMedicaService;

public class ConsultaMedicaTest {

    public static void main(String[] args) throws SQLException, ParseException {

        ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();
        ConsultaMedicaService consultaMedicaService = new ConsultaMedicaService();
        ConsultaMedica consultaMedica = new ConsultaMedica("Assinatura", Date.valueOf("2023-12-27"), 1, 1);

        // Count
        System.out.println(consultaMedicaDAO.count());
        System.out.println();

        // Insert
        consultaMedicaService.insert(consultaMedica);
        System.out.println();

        // Select all
        List<ConsultaMedica> consultaMedicas = consultaMedicaDAO.selectAll();
        consultaMedicas.forEach(System.out::println);
        System.out.println();

        // Select
        consultaMedica = consultaMedicaDAO.select(2);
        System.out.println(consultaMedica);
        System.out.println();

        // Update
        consultaMedica = consultaMedicaDAO.select(1);
        consultaMedica.setAssinatura("Assinatura 1");
        consultaMedica.setDataConsulta(Date.valueOf("2023-01-01"));
        consultaMedica.setIdMedico(1);
        consultaMedica.setIdPaciente(1);
        consultaMedicaDAO.update(consultaMedica);
        consultaMedica = consultaMedicaDAO.select(1);
        System.out.println(consultaMedica);
        System.out.println();

        // Delete
        consultaMedicaDAO.delete(35);
        consultaMedicaDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
