package com.clinica_oftalmologica.util;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.EspecialidadeMedicaDAO;
import com.clinica_oftalmologica.model.EspecialidadeMedica;
import com.clinica_oftalmologica.service.EspecialidadeMedicaService;

public class EspecialidadeMedicaTest {

    public static void main(String[] args) throws SQLException, ParseException {

        EspecialidadeMedicaDAO especialidadeMedicaDAO = new EspecialidadeMedicaDAO();
        EspecialidadeMedicaService especialidadeMedicaService = new EspecialidadeMedicaService();
        EspecialidadeMedica especialidadeMedica = new EspecialidadeMedica("Observação", Date.valueOf("2023-12-27"), 1, 1);

        // Count
        System.out.println(especialidadeMedicaDAO.count());
        System.out.println();

        // Insert
        especialidadeMedicaService.insert(especialidadeMedica);
        System.out.println();

        // Select all
        List<EspecialidadeMedica> especialidadeMedicas = especialidadeMedicaDAO.selectAll();
        especialidadeMedicas.forEach(System.out::println);
        System.out.println();

        // Select
        especialidadeMedica = especialidadeMedicaDAO.select(2);
        System.out.println(especialidadeMedica);
        System.out.println();

        // Update
        especialidadeMedica = especialidadeMedicaDAO.select(1);
        especialidadeMedica.setObservacao("Observação 1");
        especialidadeMedica.setDataConclusao(Date.valueOf("2023-01-01"));
        especialidadeMedica.setIdMedico(1);
        especialidadeMedica.setIdEspecialidade(1);
        especialidadeMedicaDAO.update(especialidadeMedica);
        especialidadeMedica = especialidadeMedicaDAO.select(1);
        System.out.println(especialidadeMedica);
        System.out.println();

        // Delete
        especialidadeMedicaDAO.delete(35);
        especialidadeMedicaDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
