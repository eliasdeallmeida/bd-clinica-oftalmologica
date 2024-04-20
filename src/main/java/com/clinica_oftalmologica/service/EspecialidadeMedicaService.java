package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.EspecialidadeMedicaDAO;
import com.clinica_oftalmologica.model.EspecialidadeMedica;

public class EspecialidadeMedicaService {

    private EspecialidadeMedicaDAO especialidadeMedicaDAO = new EspecialidadeMedicaDAO();

    public void insert(EspecialidadeMedica entity) {
        especialidadeMedicaDAO.insert(entity);
    }
}
