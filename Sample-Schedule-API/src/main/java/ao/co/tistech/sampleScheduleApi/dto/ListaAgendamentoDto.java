package ao.co.tistech.sampleScheduleApi.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ao.co.tistech.sampleScheduleApi.model.Agendamento;

public class ListaAgendamentoDto {

	private List<AgendamentoDto> listaAgendamentos = new ArrayList<>();
	
	public ListaAgendamentoDto(List<Agendamento> listaAgendamentos) {
		Optional<List<Agendamento>> candidatos = Optional.ofNullable(listaAgendamentos);
		this.listaAgendamentos.addAll(candidatos.get().stream().map(AgendamentoDto::new).collect(Collectors.toList()));
	}
	

	public List<AgendamentoDto> getListaAgendamentos() {
		return listaAgendamentos;
	}

	public void setListaAgendamentos(List<AgendamentoDto> listaAgendamentos) {
		this.listaAgendamentos = listaAgendamentos;
	}
}
