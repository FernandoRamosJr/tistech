package ao.co.tistech.sampleScheduleApi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ao.co.tistech.sampleScheduleApi.model.Sala;

public class ListaSalaDto {

	private List<SalaDto> listaSalas = new ArrayList<>();
	
	public ListaSalaDto(List<Sala> listaSalas) {
		Optional<List<Sala>> salas = Optional.ofNullable(listaSalas);
		this.listaSalas.addAll(salas.get().stream().map(SalaDto::new).collect(Collectors.toList()));
	}
	

	public List<SalaDto> getListaSalas() {
		return listaSalas;
	}

	public void setListaSalas(List<SalaDto> listaSalas) {
		this.listaSalas = listaSalas;
	}
}
