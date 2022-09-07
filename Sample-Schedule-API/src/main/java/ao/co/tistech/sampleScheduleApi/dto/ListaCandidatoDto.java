package ao.co.tistech.sampleScheduleApi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ao.co.tistech.sampleScheduleApi.model.Candidato;

public class ListaCandidatoDto {

	private List<CandidatoDto> listaCandidatos = new ArrayList<>();
	
	public ListaCandidatoDto(List<Candidato> listaCandidatos) {
		Optional<List<Candidato>> candidatos = Optional.ofNullable(listaCandidatos);
		this.listaCandidatos.addAll(candidatos.get().stream().map(CandidatoDto::new).collect(Collectors.toList()));
	}
	

	public List<CandidatoDto> getListaCandidatos() {
		return listaCandidatos;
	}

	public void setListaCandidatos(List<CandidatoDto> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
}
