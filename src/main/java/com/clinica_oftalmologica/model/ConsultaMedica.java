package com.clinica_oftalmologica.model;

import java.sql.Date;

public class ConsultaMedica extends GenericModel {

    private String assinatura;
    private Date dataConsulta;
    private Integer idMedico;
    private Integer idPaciente;

    public ConsultaMedica(String assinatura, Date dataConsulta, Integer idMedico, Integer idPaciente) {
        this.assinatura = assinatura;
        this.dataConsulta = dataConsulta;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public ConsultaMedica(Integer id, String assinatura, Date dataConsulta, Integer idMedico, Integer idPaciente) {
        this.assinatura = assinatura;
        this.dataConsulta = dataConsulta;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        super.setId(id);
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return String.format("ConsultaMedica {id = %d, assinatura = %s, data_conclusao = %tF, id_medico = %d, id_paciente = %d}", this.getId(), assinatura, dataConsulta, idMedico, idPaciente);
    }
}
