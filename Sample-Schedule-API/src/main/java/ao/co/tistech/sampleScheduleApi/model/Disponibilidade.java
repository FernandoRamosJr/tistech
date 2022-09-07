package ao.co.tistech.sampleScheduleApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ao.co.tistech.sampleScheduleApi.form.DisponibilidadeForm;

@Entity
public class Disponibilidade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String periodo;
    
    @ManyToOne
    private Sala sala;
    
    public Disponibilidade() {}
    
    public Disponibilidade(DisponibilidadeForm form) {
		this.id = form.getId();
		this.periodo = form.getPeriodo();
		this.sala = form.getSala();
	}
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
}
