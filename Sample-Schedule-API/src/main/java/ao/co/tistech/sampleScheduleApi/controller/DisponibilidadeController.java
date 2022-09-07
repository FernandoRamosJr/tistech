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

import ao.co.tistech.sampleScheduleApi.dto.DisponibilidadeDto;
import ao.co.tistech.sampleScheduleApi.dto.ListaDisponibilidadeDto;
import ao.co.tistech.sampleScheduleApi.form.DisponibilidadeForm;
import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;
import ao.co.tistech.sampleScheduleApi.service.DisponibilidadeService;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {

	@Autowired
	DisponibilidadeService service;
	
	@GetMapping
	private ResponseEntity<ListaDisponibilidadeDto> getListaDisponibilidades() {
		Optional<List<Disponibilidade>> listaDisponibilidades = service.getListaDisponibilidade();
		if (listaDisponibilidades.isPresent()) {
			return ResponseEntity.ok().body(new ListaDisponibilidadeDto(listaDisponibilidades.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<DisponibilidadeDto> getDisponibilidadePorId(@PathVariable Long id) {
		Optional<Disponibilidade> disponibilidade = service.getDisponibilidadeId(id);
		if (disponibilidade.isPresent()) {
			return ResponseEntity.ok().body(new DisponibilidadeDto(disponibilidade.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<DisponibilidadeDto> cadastrarDisponibilidade(@RequestBody @Valid DisponibilidadeForm form, UriComponentsBuilder uriBuilder) {
		Disponibilidade disponibilidade = form.converter(form);
		service.criarDisponibilidade(disponibilidade);		
		URI uri = uriBuilder.path("/disponibilidade/{id}").buildAndExpand(disponibilidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new DisponibilidadeDto(disponibilidade));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DisponibilidadeDto> atualizarDisponibilidade(@PathVariable Long id, @RequestBody @Valid DisponibilidadeForm form) {
		Disponibilidade disponibilidade = form.converter(form);		
		Optional<Disponibilidade> disponibilidadeAtualizada = service.atualiza(disponibilidade);
		if(disponibilidadeAtualizada.isPresent()) {			
			return ResponseEntity.ok(new DisponibilidadeDto(disponibilidadeAtualizada.get())) ;
		}		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerDisponibilidade(@PathVariable Long id) {		
		Optional<Disponibilidade> disponibilidade = service.getDisponibilidadeId(id);
		if (disponibilidade.isPresent()) {
			service.remove(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();
	}
}
