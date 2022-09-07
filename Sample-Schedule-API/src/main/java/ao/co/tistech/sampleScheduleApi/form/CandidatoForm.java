package ao.co.tistech.sampleScheduleApi.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ao.co.tistech.sampleScheduleApi.model.Candidato;

public class CandidatoForm {

	private Long id;
    private String nome;
    private String email;
    private String senha;
    
    public CandidatoForm(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
    
    public Candidato converter(CandidatoForm form) {    	
    	form.setSenha(bCryptSenha(form.senha)); 	
    	return new Candidato(form);
    }

	private String bCryptSenha(String senha) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();  
        return bCryptPasswordEncoder.encode(senha);
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
