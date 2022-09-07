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

import ao.co.tistech.sampleScheduleApi.dto.SalaDto;
import ao.co.tistech.sampleScheduleApi.dto.ListaSalaDto;
import ao.co.tistech.sampleScheduleApi.form.SalaForm;
import ao.co.tistech.sampleScheduleApi.model.Sala;
import ao.co.tistech.sampleScheduleApi.service.SalaService;

@RestController
@RequestMapping("/sala")
public class SalaController {

	@Autowired
	SalaService service;
	
	@GetMapping
	private ResponseEntity<ListaSalaDto> getListaSalas() {
		Optional<List<Sala>> listaSalas = service.getListaSala();
		if (listaSalas.isPresent()) {
			return ResponseEntity.ok().body(new ListaSalaDto(listaSalas.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<SalaDto> getSalaPorId(@PathVariable Long id) {
		Optional<Sala> sala = service.getSalaId(id);
		if (sala.isPresent()) {
			return ResponseEntity.ok().body(new SalaDto(sala.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<SalaDto> cadastrarSala(@RequestBody @Valid SalaForm form, UriComponentsBuilder uriBuilder) {
		Sala sala = form.converter(form);
		service.criarSala(sala);		
		URI uri = uriBuilder.path("/sala/{id}").buildAndExpand(sala.getId()).toUri();
		return ResponseEntity.created(uri).body(new SalaDto(sala));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SalaDto> atualizarSala(@PathVariable Long id, @RequestBody @Valid SalaForm form) {
		Sala sala = form.converter(form);		
		Optional<Sala> salaAtualizada = service.atualiza(sala);
		if(salaAtualizada.isPresent()) {			
			return ResponseEntity.ok(new SalaDto(salaAtualizada.get())) ;
		}		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerSala(@PathVariable Long id) {		
		Optional<Sala> sala = service.getSalaId(id);
		if (sala.isPresent()) {
			service.remove(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
}
