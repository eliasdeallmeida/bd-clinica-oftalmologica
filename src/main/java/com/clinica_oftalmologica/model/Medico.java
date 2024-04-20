package com.clinica_oftalmologica.model;

public class Medico extends GenericModel {

    private String nome;
    private String crm;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public Medico(Integer id, String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return String.format("Medico {id = %d, nome = %s, crm = %s}", this.getId(), nome, crm);
    }
}
