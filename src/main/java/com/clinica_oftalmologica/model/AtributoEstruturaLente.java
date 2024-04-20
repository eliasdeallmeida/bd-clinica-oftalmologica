package com.clinica_oftalmologica.model;

public class AtributoEstruturaLente extends GenericModel {

    private String descricao;
    private String ladoOlho;

    public AtributoEstruturaLente(String descricao, String ladoOlho) {
        this.descricao = descricao;
        this.ladoOlho = ladoOlho;
    }

    public AtributoEstruturaLente(Integer id, String descricao, String ladoOlho) {
        this.descricao = descricao;
        this.ladoOlho = ladoOlho;
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLadoOlho() {
        return ladoOlho;
    }

    public void setLadoOlho(String ladoOlho) {
        this.ladoOlho = ladoOlho;
    }

    @Override
    public String toString() {
        return String.format("AtributoEstruturaLente {id = %d, descricao = %s, lado_olho = %s}", this.getId(), descricao, ladoOlho);
    }
}
