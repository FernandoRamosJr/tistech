package ao.co.tistech.sampleScheduleApi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ao.co.tistech.sampleScheduleApi.form.SalaForm;

@Entity
public class Sala {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;

    @OneToMany(mappedBy = "sala")
    private List<Disponibilidade> listaDisponibilidade = new ArrayList<>();
        
    public Sala() {}
    
    public Sala(SalaForm form) {
		this.id = form.getId();
		this.numero = form.getNumero();
		this.listaDisponibilidade.addAll(form.getDisponibilidade());
	}
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public List<Disponibilidade> getListaDisponibilidade() {
		return listaDisponibilidade;
	}
	
	public void setListaDisponibilidade(List<Disponibilidade> listaDisponibilidade) {
		this.listaDisponibilidade = listaDisponibilidade;
	}
}
