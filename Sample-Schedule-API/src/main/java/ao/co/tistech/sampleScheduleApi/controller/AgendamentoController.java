package ao.co.tistech.sampleScheduleApi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ao.co.tistech.sampleScheduleApi.dto.AgendamentoDto;
import ao.co.tistech.sampleScheduleApi.dto.ListaAgendamentoDto;
import ao.co.tistech.sampleScheduleApi.form.AgendamentoForm;
import ao.co.tistech.sampleScheduleApi.model.Agendamento;
import ao.co.tistech.sampleScheduleApi.service.AgendamentoService;
import ao.co.tistech.sampleScheduleApi.service.DisponibilidadeService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	AgendamentoService service;
	
	@Autowired
	DisponibilidadeService disponibilidadeService;
	
	@GetMapping
	private ResponseEntity<ListaAgendamentoDto> getListaAgendamentos() {
		Optional<List<Agendamento>> listaAgendamentos = service.getListaAgendamento();
		if (listaAgendamentos.isPresent()) {
			return ResponseEntity.ok().body(new ListaAgendamentoDto(listaAgendamentos.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<AgendamentoDto> getAgendamentoPorId(@PathVariable Long id) {
		Optional<Agendamento> agendamento = service.getAgendamentoId(id);
		if (agendamento.isPresent()) {
			return ResponseEntity.ok().body(new AgendamentoDto(agendamento.get()));
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<AgendamentoDto> cadastrarAgendamento(@RequestBody @Valid AgendamentoForm form, UriComponentsBuilder uriBuilder) {
		Optional<Agendamento> disponibilidade = service.getAgendamentoPorDisponibilidadeId(form.getDisponibilidade().getId());
		if(disponibilidade.isEmpty()) {
			Agendamento agendamento = form.converter(form);
			service.criarAgendamento(agendamento);		
			URI uri = uriBuilder.path("/agendamento/{id}").buildAndExpand(agendamento.getId()).toUri();
			return ResponseEntity.created(uri).body(new AgendamentoDto(agendamento));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AgendamentoDto> atualizarAgendamento(@PathVariable Long id, @RequestBody @Valid AgendamentoForm form) {
		Agendamento agendamento = form.converter(form);		
		Optional<Agendamento> agendamentoAtualizada = service.atualiza(agendamento);
		if(agendamentoAtualizada.isPresent()) {			
			return ResponseEntity.ok(new AgendamentoDto(agendamentoAtualizada.get())) ;
		}		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerAgendamento(@PathVariable Long id) {		
		Optional<Agendamento> agendamento = service.getAgendamentoId(id);
		if (agendamento.isPresent()) {
			service.remove(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
}
