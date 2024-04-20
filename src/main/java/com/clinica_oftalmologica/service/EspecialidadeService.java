package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.EspecialidadeDAO;
import com.clinica_oftalmologica.model.Especialidade;

public class EspecialidadeService {

    private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    public void insert(Especialidade entity) {
        especialidadeDAO.insert(entity);
    }
}
