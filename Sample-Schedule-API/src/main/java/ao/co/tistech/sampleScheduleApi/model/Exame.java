package ao.co.tistech.sampleScheduleApi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ao.co.tistech.sampleScheduleApi.form.ExameForm;

@Entity
public class Exame {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    
    public Exame() {}
    
    public Exame(ExameForm form) {
		this.id = form.getId();
		this.nome = form.getNome();
		this.descricao = form.getDescricao();
	}
    
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
