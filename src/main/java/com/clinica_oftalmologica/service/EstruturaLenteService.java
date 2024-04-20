package com.clinica_oftalmologica.service;

import com.clinica_oftalmologica.dao.EstruturaLenteDAO;
import com.clinica_oftalmologica.model.EstruturaLente;

public class EstruturaLenteService {

    private EstruturaLenteDAO estruturaLenteDAO = new EstruturaLenteDAO();

    public void insert(EstruturaLente entity) {
        estruturaLenteDAO.insert(entity);
    }
}
