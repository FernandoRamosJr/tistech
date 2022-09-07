package ao.co.tistech.sampleScheduleApi.controller;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ao.co.tistech.sampleScheduleApi.config.security.TokenService;
import ao.co.tistech.sampleScheduleApi.form.CandidatoForm;
import ao.co.tistech.sampleScheduleApi.form.LoginForm;
import ao.co.tistech.sampleScheduleApi.model.Candidato;
import ao.co.tistech.sampleScheduleApi.repository.CandidatoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AgendamentoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private AuthenticationManager authManager;
	
    @Autowired
    private TokenService tokenService;
    
    private CandidatoRepository repository;
    
    private static String password;
    
	@Test
	public void agendamentoConcluidoComSucesso() throws Exception {
		LoginForm form = new LoginForm("admin@admin.com", "admin"); 
		password = form.getPassword();
		
		UsernamePasswordAuthenticationToken loginData = form.convert();
		Authentication authentication = authManager.authenticate(loginData);
        String token = tokenService.generateToken(authentication);
		
        Long candidatoId = tokenService.getCandidatoId(token);
        Candidato candidato = new Candidato(new CandidatoForm(1L, "admin","admin@admin.com","admin")); 
        UsernamePasswordAuthenticationToken authenticationLogged = new UsernamePasswordAuthenticationToken(candidato, null, candidato.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
				
		URI uri = new URI("/agendamento");
		String json = "{\"candidato\":{\"id\":\"1\",\"nome\":\"Fernando Ramos Jr\",\"email\":\"theclansman86@hotmail.com\",\"senha\":\"admin2\"},\"exame\":{\"id\":1,\"nome\":\"OCAJP - Java Programmer SE 11111\",\"descricao\":\"Oracle Certified Associate Java Programmer SE 11 Programmer I\"},\"disponibilidade\":{\"id\":\"1\",\"periodo\":\"13:00\",\"sala\":{\"id\":1,\"numero\":1011,\"disponibilidadeDto\":{\"listaDisponibilidades\":[]}}}}";
		
		mockMvc
			.perform(MockMvcRequestBuilders
					.post(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.header("Bearer", token)
					.content(json)
					)
			.andExpect(MockMvcResultMatchers
					.status()
					.is(201));
		
	}
	
	@Test
	public void erroDeAgendamentoPorDisponibilidadeEmUso() throws Exception {
		LoginForm form = new LoginForm("admin@admin.com", "admin"); 
		password = form.getPassword();
		
		UsernamePasswordAuthenticationToken loginData = form.convert();
		Authentication authentication = authManager.authenticate(loginData);
        String token = tokenService.generateToken(authentication);
		
        Long candidatoId = tokenService.getCandidatoId(token);
        Candidato candidato = new Candidato(new CandidatoForm(1L, "admin","admin@admin.com","admin")); 
        UsernamePasswordAuthenticationToken authenticationLogged = new UsernamePasswordAuthenticationToken(candidato, null, candidato.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
				
		URI uri = new URI("/agendamento");
		String json = "{\"candidato\":{\"id\":\"1\",\"nome\":\"Fernando Ramos Jr\",\"email\":\"theclansman86@hotmail.com\",\"senha\":\"admin2\"},\"exame\":{\"id\":1,\"nome\":\"OCAJP - Java Programmer SE 11111\",\"descricao\":\"Oracle Certified Associate Java Programmer SE 11 Programmer I\"},\"disponibilidade\":{\"id\":\"1\",\"periodo\":\"13:00\",\"sala\":{\"id\":1,\"numero\":1011,\"disponibilidadeDto\":{\"listaDisponibilidades\":[]}}}}";
		
		mockMvc
			.perform(MockMvcRequestBuilders
					.post(uri)
					.contentType(MediaType.APPLICATION_JSON)
					.header("Bearer", token)
					.content(json)
					)
			.andExpect(MockMvcResultMatchers
					.status()
					.is(404));
		
	}
}
