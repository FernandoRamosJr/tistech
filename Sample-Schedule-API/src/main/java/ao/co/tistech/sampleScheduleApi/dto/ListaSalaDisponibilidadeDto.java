package ao.co.tistech.sampleScheduleApi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;

public class ListaSalaDisponibilidadeDto {

	private List<SalaDisponibilidadeDto> listaDisponibilidades = new ArrayList<>();
	
	public ListaSalaDisponibilidadeDto(List<Disponibilidade> listaDisponibilidades) {
		Optional<List<Disponibilidade>> disponibilidades = Optional.ofNullable(listaDisponibilidades);
		this.listaDisponibilidades.addAll(disponibilidades.get().stream().map(SalaDisponibilidadeDto::new).collect(Collectors.toList()));
	}

	public List<SalaDisponibilidadeDto> getListaDisponibilidades() {
		return listaDisponibilidades;
	}

	public void setListaDisponibilidades(List<SalaDisponibilidadeDto> listaDisponibilidades) {
		this.listaDisponibilidades = listaDisponibilidades;
	}
}
