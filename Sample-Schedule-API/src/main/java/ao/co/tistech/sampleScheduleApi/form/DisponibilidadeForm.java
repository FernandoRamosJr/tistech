package ao.co.tistech.sampleScheduleApi.form;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;
import ao.co.tistech.sampleScheduleApi.model.Sala;

public class DisponibilidadeForm {
	
	private Long id;
    private String periodo;
    private Sala sala;
    
    public Disponibilidade converter(DisponibilidadeForm form) { 
    	return new Disponibilidade(form);
    }
    
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
}
