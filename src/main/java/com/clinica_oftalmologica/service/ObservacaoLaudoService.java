package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.ObservacaoLaudoDAO;
import com.clinica_oftalmologica.model.ObservacaoLaudo;

public class ObservacaoLaudoService {

    private ObservacaoLaudoDAO observacaoLaudoDAO = new ObservacaoLaudoDAO();

    public void insert(ObservacaoLaudo entity) {
        observacaoLaudoDAO.insert(entity);
    }
}
