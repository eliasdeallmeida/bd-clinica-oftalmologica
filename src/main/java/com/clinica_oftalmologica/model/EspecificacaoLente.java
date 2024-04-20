package com.clinica_oftalmologica.model;

public class EspecificacaoLente extends GenericModel {

    private Float valor;
    private Integer idEstruturaLente;
    private Integer idAtributoEstruturaLente;

    public EspecificacaoLente(Integer idEstruturaLente, Integer idAtributoEstruturaLente) {
        this.idEstruturaLente = idEstruturaLente;
        this.idAtributoEstruturaLente = idAtributoEstruturaLente;
    }

    public EspecificacaoLente(Float valor, Integer idEstruturaLente, Integer idAtributoEstruturaLente) {
        this.valor = valor;
        this.idEstruturaLente = idEstruturaLente;
        this.idAtributoEstruturaLente = idAtributoEstruturaLente;
    }

    public EspecificacaoLente(Integer id, Float valor, Integer idEstruturaLente, Integer idAtributoEstruturaLente) {
        this.valor = valor;
        this.idEstruturaLente = idEstruturaLente;
        this.idAtributoEstruturaLente = idAtributoEstruturaLente;
        super.setId(id);
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getIdEstruturaLente() {
        return idEstruturaLente;
    }

    public void setIdEstruturaLente(Integer idEstruturaLente) {
        this.idEstruturaLente = idEstruturaLente;
    }

    public Integer getIdAtributoEstruturaLente() {
        return idAtributoEstruturaLente;
    }

    public void setIdAtributoEstruturaLente(Integer idAtributoEstruturaLente) {
        this.idAtributoEstruturaLente = idAtributoEstruturaLente;
    }

    @Override
    public String toString() {
        return String.format("EspecificacaoLente {id = %d, valor = %.2f, id_estrutura_lente = %d, id_atributo_estrutura_lente = %d}", this.getId(), valor, idEstruturaLente, idAtributoEstruturaLente);
    }
}
