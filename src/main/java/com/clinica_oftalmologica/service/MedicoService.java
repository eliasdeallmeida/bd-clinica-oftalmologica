package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.MedicoDAO;
import com.clinica_oftalmologica.model.Medico;

public class MedicoService {

    private MedicoDAO medicoDAO = new MedicoDAO();

    public void insert(Medico entity) {
        medicoDAO.insert(entity);
    }
}
