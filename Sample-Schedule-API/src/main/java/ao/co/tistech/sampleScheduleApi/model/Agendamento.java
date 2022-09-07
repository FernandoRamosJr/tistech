package ao.co.tistech.sampleScheduleApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ao.co.tistech.sampleScheduleApi.form.AgendamentoForm;

@Entity
public class Agendamento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Candidato candidato;

    @OneToOne
    private Exame exame;

    @OneToOne
    private Disponibilidade disponibilidade;
    
    public Agendamento() {}
    
    public Agendamento(AgendamentoForm form) {
		this.id = form.getId();
		this.candidato = form.getCandidato();
		this.exame = form.getExame();
		this.disponibilidade = form.getDisponibilidade();
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
