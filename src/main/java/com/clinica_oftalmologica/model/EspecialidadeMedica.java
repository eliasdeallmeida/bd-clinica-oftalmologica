package com.clinica_oftalmologica.model;

import java.sql.Date;

public class EspecialidadeMedica extends GenericModel {

    private String observacao;
    private Date dataConclusao;
    private Integer idMedico;
    private Integer idEspecialidade;

    public EspecialidadeMedica(Integer idMedico, Integer idEspecialidade) {
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
    }

    public EspecialidadeMedica(String observacao, Integer idMedico, Integer idEspecialidade) {
        this.observacao = observacao;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
    }

    public EspecialidadeMedica(Date dataConclusao, Integer idMedico, Integer idEspecialidade) {
        this.dataConclusao = dataConclusao;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
    }

    public EspecialidadeMedica(String observacao, Date dataConclusao, Integer idMedico, Integer idEspecialidade) {
        this.observacao = observacao;
        this.dataConclusao = dataConclusao;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
    }

    public EspecialidadeMedica(Integer id, String observacao, Date dataConclusao, Integer idMedico, Integer idEspecialidade) {
        this.observacao = observacao;
        this.dataConclusao = dataConclusao;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
        super.setId(id);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    @Override
    public String toString() {
        return String.format("EspecialidadeMedica {id = %d, observacao = %s, data_conclusao = %tF, id_medico = %d, id_especialidade = %d}", this.getId(), observacao, dataConclusao, idMedico, idEspecialidade);
    }
}
