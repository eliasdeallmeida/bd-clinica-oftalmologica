package com.clinica_oftalmologica.util;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.clinica_oftalmologica.dao.EspecialidadeDAO;
import com.clinica_oftalmologica.model.Especialidade;
import com.clinica_oftalmologica.service.EspecialidadeService;

public class EspecialidadeTest {

    public static void main(String[] args) throws SQLException, ParseException {

        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        EspecialidadeService especialidadeService = new EspecialidadeService();
        Especialidade especialidade = new Especialidade("Oftalmologia", "Conselho Brasileiro de Oftalmologia");

        // Count
        System.out.println(especialidadeDAO.count());
        System.out.println();

        // Insert
        especialidadeService.insert(especialidade);
        System.out.println();

        // Select all
        List<Especialidade> especialidades = especialidadeDAO.selectAll();
        especialidades.forEach(System.out::println);
        System.out.println();

        // Select
        especialidade = especialidadeDAO.select(3);
        System.out.println(especialidade);
        System.out.println();

        // Update
        especialidade = especialidadeDAO.select(1);
        especialidade.setDescricao("Neurologia");
        especialidade.setConselho("Conselho Brasileiro de Neurologia");
        especialidadeDAO.update(especialidade);
        especialidade = especialidadeDAO.select(1);
        System.out.println(especialidade);
        System.out.println();

        // Delete
        especialidadeDAO.delete(2);
        especialidadeDAO.selectAll().forEach(System.out::println);
        System.out.println();
    }
}
