package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;

public class DisponibilidadeDto {

	private Long id;
    private String periodo;
    private DisponibilidadeSalaDto disponibilidadeSalaDto;
    
    public DisponibilidadeDto(Disponibilidade disponibilidade) {
		this.id = disponibilidade.getId();
		this.periodo = disponibilidade.getPeriodo();
		this.disponibilidadeSalaDto = new DisponibilidadeSalaDto(disponibilidade.getSala());
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

	public DisponibilidadeSalaDto getDisponibilidadeSalaDto() {
		return disponibilidadeSalaDto;
	}

	public void setDisponibilidadeSalaDto(DisponibilidadeSalaDto disponibilidadeSalaDto) {
		this.disponibilidadeSalaDto = disponibilidadeSalaDto;
	}
}
