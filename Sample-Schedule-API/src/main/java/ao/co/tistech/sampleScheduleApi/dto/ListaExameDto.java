package ao.co.tistech.sampleScheduleApi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ao.co.tistech.sampleScheduleApi.model.Exame;

public class ListaExameDto {

	private List<ExameDto> listaExames = new ArrayList<>();
	
	public ListaExameDto(List<Exame> listaExames) {
		Optional<List<Exame>> exames = Optional.ofNullable(listaExames);
		this.listaExames.addAll(exames.get().stream().map(ExameDto::new).collect(Collectors.toList()));
	}
	

	public List<ExameDto> getListaExames() {
		return listaExames;
	}

	public void setListaExames(List<ExameDto> listaExames) {
		this.listaExames = listaExames;
	}
}
