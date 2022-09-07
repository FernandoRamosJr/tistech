package ao.co.tistech.sampleScheduleApi.form;

import ao.co.tistech.sampleScheduleApi.model.Exame;

public class ExameForm {
	
	private Long id;
    private String nome;
    private String descricao;
    
    public Exame converter(ExameForm form) { 
    	return new Exame(form);
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
