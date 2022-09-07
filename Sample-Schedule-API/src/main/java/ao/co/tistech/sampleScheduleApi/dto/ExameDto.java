package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Exame;

public class ExameDto {

	private Long id;
    private String nome;
    private String descricao;
    
    public ExameDto(Exame exame) {
		this.id = exame.getId();
		this.nome = exame.getNome();
		this.descricao = exame.getDescricao();
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
