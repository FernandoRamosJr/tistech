package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Sala;

public class DisponibilidadeSalaDto {

	private Long id;
    private Integer numero;
    
    public DisponibilidadeSalaDto(Sala sala) {
		this.id = sala.getId();
		this.numero = sala.getNumero();
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
}
