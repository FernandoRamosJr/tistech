package ao.co.tistech.sampleScheduleApi.dto;

import ao.co.tistech.sampleScheduleApi.model.Candidato;

public class CandidatoDto {

	private Long id;
    private String nome;
    private String email;
    private String senha;
    
    public CandidatoDto(Candidato candidato) {
		this.id = candidato.getId();
		this.nome = candidato.getNome();
		this.email = candidato.getEmail();
		this.senha = candidato.getSenha();
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
