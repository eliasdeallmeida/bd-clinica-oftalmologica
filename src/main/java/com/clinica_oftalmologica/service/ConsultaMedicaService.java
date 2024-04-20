package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.ConsultaMedicaDAO;
import com.clinica_oftalmologica.model.ConsultaMedica;

public class ConsultaMedicaService {

    private ConsultaMedicaDAO consultaMedicaDAO = new ConsultaMedicaDAO();

    public void insert(ConsultaMedica entity) {
        consultaMedicaDAO.insert(entity);
    }
}
