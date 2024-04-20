package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.ReceitaOculosDAO;
import com.clinica_oftalmologica.model.ReceitaOculos;

public class ReceitaOculosService {

    private ReceitaOculosDAO receitaOculosDAO = new ReceitaOculosDAO();

    public void insert(ReceitaOculos entity) {
        receitaOculosDAO.insert(entity);
    }
}
