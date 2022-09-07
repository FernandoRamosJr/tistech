package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;

public class SalaDisponibilidadeDto {

	private Long id;
    private String periodo;
    
    public SalaDisponibilidadeDto(Disponibilidade disponibilidade) {
		this.id = disponibilidade.getId();
		this.periodo = disponibilidade.getPeriodo();
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
}
