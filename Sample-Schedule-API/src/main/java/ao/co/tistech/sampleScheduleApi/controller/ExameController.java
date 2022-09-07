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

import ao.co.tistech.sampleScheduleApi.dto.ExameDto;
import ao.co.tistech.sampleScheduleApi.dto.ListaExameDto;
import ao.co.tistech.sampleScheduleApi.form.ExameForm;
import ao.co.tistech.sampleScheduleApi.model.Exame;
import ao.co.tistech.sampleScheduleApi.service.ExameService;

@RestController
@RequestMapping("/exame")
public class ExameController {

	@Autowired
	ExameService service;
	
	@GetMapping
	private ResponseEntity<ListaExameDto> getListaExames() {
		Optional<List<Exame>> listaExames = service.getListaExame();
		if (listaExames.isPresent()) {
			return ResponseEntity.ok().body(new ListaExameDto(listaExames.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<ExameDto> getExamePorId(@PathVariable Long id) {
		Optional<Exame> exame = service.getExameId(id);
		if (exame.isPresent()) {
			return ResponseEntity.ok().body(new ExameDto(exame.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ExameDto> cadastrarExame(@RequestBody @Valid ExameForm form, UriComponentsBuilder uriBuilder) {
		Exame exame = form.converter(form);
		service.criarExame(exame);		
		URI uri = uriBuilder.path("/exame/{id}").buildAndExpand(exame.getId()).toUri();
		return ResponseEntity.created(uri).body(new ExameDto(exame));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ExameDto> atualizarExame(@PathVariable Long id, @RequestBody @Valid ExameForm form) {
		Exame exame = form.converter(form);		
		Optional<Exame> exameAtualizado = service.atualiza(exame);
		if(exameAtualizado.isPresent()) {			
			return ResponseEntity.ok(new ExameDto(exameAtualizado.get())) ;
		}		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerExame(@PathVariable Long id) {		
		Optional<Exame> exame = service.getExameId(id);
		if (exame.isPresent()) {
			service.remove(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
}
