package ao.co.tistech.sampleScheduleApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.co.tistech.sampleScheduleApi.model.Candidato;
import ao.co.tistech.sampleScheduleApi.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
    CandidatoRepository repository;
	
	public Optional<List<Candidato>> getListaCandidato() {
        Optional<List<Candidato>> listaCandidatos = Optional.of(repository.findAll());
        return listaCandidatos;
    }
	
    public Optional<Candidato> getCandidatoId(Long idCandidato) {
        Optional<Candidato> candidato = repository.findById(idCandidato);
        return candidato;
    }

	public void criarCandidato(Candidato candidato) {
		repository.save(candidato);		
	}
	
	public Optional<Candidato> atualiza(Candidato candidato) {
		Optional<Candidato> candidatoAtualizado = repository.findById(candidato.getId());
		
		candidatoAtualizado.get().setNome(candidato.getNome());
		candidatoAtualizado.get().setEmail(candidato.getEmail());
		candidatoAtualizado.get().setSenha(candidato.getSenha());
		
		repository.save(candidatoAtualizado.get());
		
		return Optional.ofNullable(candidatoAtualizado.get());
	}

	public void remove(Long id) {
		repository.deleteById(id);
	}

}
