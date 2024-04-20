package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.PacienteDAO;
import com.clinica_oftalmologica.model.Paciente;

public class PacienteService {

    private PacienteDAO pacienteDAO = new PacienteDAO();

    public void insert(Paciente entity) {
        pacienteDAO.insert(entity);
    }
}
