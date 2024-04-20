package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.AtributoEstruturaLenteDAO;
import com.clinica_oftalmologica.model.AtributoEstruturaLente;

public class AtributoEstruturaLenteService {

    private AtributoEstruturaLenteDAO atributoEstruturaLenteDAO = new AtributoEstruturaLenteDAO();

    public void insert(AtributoEstruturaLente entity) {
        atributoEstruturaLenteDAO.insert(entity);
    }
}
