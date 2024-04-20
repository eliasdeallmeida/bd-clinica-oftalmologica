package com.clinica_oftalmologica.model;

public class ReceitaOculos extends GenericModel {

    private String detalhamento;
    private Integer idConsultaMedica;

    public ReceitaOculos(Integer idConsultaMedica) {
        this.idConsultaMedica = idConsultaMedica;
    }

    public ReceitaOculos(String detalhamento, Integer idConsultaMedica) {
        this.detalhamento = detalhamento;
        this.idConsultaMedica = idConsultaMedica;
    }

    public ReceitaOculos(Integer id, String detalhamento, Integer idConsultaMedica) {
        this.detalhamento = detalhamento;
        this.idConsultaMedica = idConsultaMedica;
        super.setId(id);
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Integer getIdConsultaMedica() {
        return idConsultaMedica;
    }

    public void setIdConsultaMedica(Integer idConsultaMedica) {
        this.idConsultaMedica = idConsultaMedica;
    }

    @Override
    public String toString() {
        return String.format("ReceitaOculos {id = %d, detalhamento = %s, id_consulta_medica = %d", this.getId(), detalhamento, idConsultaMedica);
    }
}
