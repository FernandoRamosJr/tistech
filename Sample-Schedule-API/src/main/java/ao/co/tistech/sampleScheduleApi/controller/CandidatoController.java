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

import ao.co.tistech.sampleScheduleApi.dto.CandidatoDto;
import ao.co.tistech.sampleScheduleApi.dto.ListaCandidatoDto;
import ao.co.tistech.sampleScheduleApi.form.CandidatoForm;
import ao.co.tistech.sampleScheduleApi.model.Candidato;
import ao.co.tistech.sampleScheduleApi.service.CandidatoService;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	CandidatoService service;
	
	@GetMapping
	private ResponseEntity<ListaCandidatoDto> getListaCandidatos() {
		Optional<List<Candidato>> listaCandidatos = service.getListaCandidato();
		if (listaCandidatos.isPresent()) {
			return ResponseEntity.ok().body(new ListaCandidatoDto(listaCandidatos.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<CandidatoDto> getCandidatoPorId(@PathVariable Long id) {
		Optional<Candidato> candidato = service.getCandidatoId(id);
		if (candidato.isPresent()) {
			return ResponseEntity.ok().body(new CandidatoDto(candidato.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CandidatoDto> cadastrarCandidato(@RequestBody @Valid CandidatoForm form, UriComponentsBuilder uriBuilder) {
		Candidato candidato = form.converter(form);
		service.criarCandidato(candidato);		
		URI uri = uriBuilder.path("/candidato/{id}").buildAndExpand(candidato.getId()).toUri();
		return ResponseEntity.created(uri).body(new CandidatoDto(candidato));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CandidatoDto> atualizarCandidato(@PathVariable Long id, @RequestBody @Valid CandidatoForm form) {
		Candidato candidato = form.converter(form);		
		Optional<Candidato> candidatoAtualizado = service.atualiza(candidato);
		if(candidatoAtualizado.isPresent()) {			
			return ResponseEntity.ok(new CandidatoDto(candidatoAtualizado.get())) ;
		}		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerCandidato(@PathVariable Long id) {		
		Optional<Candidato> candidato = service.getCandidatoId(id);
		if (candidato.isPresent()) {
			service.remove(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
}
