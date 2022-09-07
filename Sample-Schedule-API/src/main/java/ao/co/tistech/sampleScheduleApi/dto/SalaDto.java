package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Sala;

public class SalaDto {

	private Long id;
    private Integer numero;
    private ListaSalaDisponibilidadeDto listaSalaDisponibilidadeDto;
    
    public SalaDto(Sala sala) {
		this.id = sala.getId();
		this.numero = sala.getNumero();
		this.listaSalaDisponibilidadeDto = new ListaSalaDisponibilidadeDto(sala.getListaDisponibilidade());
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

	public ListaSalaDisponibilidadeDto getListaSalaDisponibilidadeDto() {
		return listaSalaDisponibilidadeDto;
	}

	public void setListaSalaDisponibilidadeDto(ListaSalaDisponibilidadeDto listaSalaDisponibilidadeDto) {
		this.listaSalaDisponibilidadeDto = listaSalaDisponibilidadeDto;
	}
}
