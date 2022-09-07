package ao.co.tistech.sampleScheduleApi.form;

import ao.co.tistech.sampleScheduleApi.model.Agendamento;
import ao.co.tistech.sampleScheduleApi.model.Candidato;
import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;
import ao.co.tistech.sampleScheduleApi.model.Exame;

public class AgendamentoForm {
	
	private Long id;
    private Candidato candidato;
    private Exame exame;
    private Disponibilidade disponibilidade;
    
    public Agendamento converter(AgendamentoForm form) { 
    	return new Agendamento(form);
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}
