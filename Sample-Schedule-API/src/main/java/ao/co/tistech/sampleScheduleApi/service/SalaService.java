package ao.co.tistech.sampleScheduleApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.co.tistech.sampleScheduleApi.model.Sala;
import ao.co.tistech.sampleScheduleApi.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
    SalaRepository repository;
	
	public Optional<List<Sala>> getListaSala() {
        Optional<List<Sala>> listaSalas = Optional.of(repository.findAll());
        return listaSalas;
    }
	
    public Optional<Sala> getSalaId(Long idSala) {
        Optional<Sala> sala = repository.findById(idSala);
        return sala;
    }

	public void criarSala(Sala sala) {
		repository.save(sala);		
	}
	
	public Optional<Sala> atualiza(Sala sala) {
		Optional<Sala> salaAtualizado = repository.findById(sala.getId());
		
		salaAtualizado.get().setNumero(sala.getNumero());
				
		repository.save(salaAtualizado.get());
		
		return Optional.ofNullable(salaAtualizado.get());
	}

	public void remove(Long id) {
		repository.deleteById(id);
	}

}
