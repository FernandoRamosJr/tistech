package ao.co.tistech.sampleScheduleApi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;

public class ListaDisponibilidadeDto {

	private List<DisponibilidadeDto> listaDisponibilidades = new ArrayList<>();
	
	public ListaDisponibilidadeDto(List<Disponibilidade> listaDisponibilidades) {
		Optional<List<Disponibilidade>> disponibilidades = Optional.ofNullable(listaDisponibilidades);
		this.listaDisponibilidades.addAll(disponibilidades.get().stream().map(DisponibilidadeDto::new).collect(Collectors.toList()));
	}
	

	public List<DisponibilidadeDto> getListaDisponibilidades() {
		return listaDisponibilidades;
	}

	public void setListaDisponibilidades(List<DisponibilidadeDto> listaDisponibilidades) {
		this.listaDisponibilidades = listaDisponibilidades;
	}
}
