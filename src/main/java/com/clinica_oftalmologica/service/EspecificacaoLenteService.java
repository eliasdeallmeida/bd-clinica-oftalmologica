package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.EspecificacaoLenteDAO;
import com.clinica_oftalmologica.model.EspecificacaoLente;

public class EspecificacaoLenteService {

    private EspecificacaoLenteDAO especificacaoLenteDAO = new EspecificacaoLenteDAO();

    public void insert(EspecificacaoLente entity) {
        especificacaoLenteDAO.insert(entity);
    }
}
