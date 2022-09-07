package ao.co.tistech.sampleScheduleApi.form;

import java.util.ArrayList;
import java.util.List;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;
import ao.co.tistech.sampleScheduleApi.model.Sala;

public class SalaForm {
	
	private Long id;
    private Integer numero;
    private List<Disponibilidade> disponibilidade = new ArrayList<>();
    
    public Sala converter(SalaForm form) { 
    	return new Sala(form);
    }
    
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Disponibilidade> getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(List<Disponibilidade> disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}
