package com.clinica_oftalmologica.model;

public class Especialidade extends GenericModel {

    private String descricao;
    private String conselho;

    public Especialidade(String descricao, String conselho) {
        this.descricao = descricao;
        this.conselho = conselho;
    }

    public Especialidade(Integer id, String descricao, String conselho) {
        this.descricao = descricao;
        this.conselho = conselho;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    @Override
    public String toString() {
        return String.format("Especialidade {id = %d, descricao = %s, conselho = %s}", this.getId(), descricao, conselho);
    }
}
