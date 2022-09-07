package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Agendamento;

public class AgendamentoDto {

	private Long id;
    private CandidatoDto candidato;
    private ExameDto exame;
    private DisponibilidadeDto disponibilidade;
    
    public AgendamentoDto(Agendamento exame) {
		this.id = exame.getId();
		this.candidato = new CandidatoDto(exame.getCandidato());
		this.exame = new ExameDto(exame.getExame());
		this.disponibilidade = new DisponibilidadeDto(exame.getDisponibilidade());
	}
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CandidatoDto getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoDto candidato) {
		this.candidato = candidato;
	}

	public ExameDto getExame() {
		return exame;
	}

	public void setExame(ExameDto exame) {
		this.exame = exame;
	}

	public DisponibilidadeDto getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadeDto disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
    	
}
