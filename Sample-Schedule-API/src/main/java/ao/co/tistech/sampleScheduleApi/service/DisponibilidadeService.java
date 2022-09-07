package ao.co.tistech.sampleScheduleApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.co.tistech.sampleScheduleApi.model.Disponibilidade;
import ao.co.tistech.sampleScheduleApi.repository.DisponibilidadeRepository;

@Service
public class DisponibilidadeService {
	
	@Autowired
    DisponibilidadeRepository repository;
	
	public Optional<List<Disponibilidade>> getListaDisponibilidade() {
        Optional<List<Disponibilidade>> listaDisponibilidades = Optional.of(repository.findAll());
        return listaDisponibilidades;
    }
	
    public Optional<Disponibilidade> getDisponibilidadeId(Long idDisponibilidade) {
        Optional<Disponibilidade> disponibilidade = repository.findById(idDisponibilidade);
        return disponibilidade;
    }

	public void criarDisponibilidade(Disponibilidade disponibilidade) {
		repository.save(disponibilidade);		
	}
	
	public Optional<Disponibilidade> atualiza(Disponibilidade disponibilidade) {
		Optional<Disponibilidade> disponibilidadeAtualizado = repository.findById(disponibilidade.getId());
		
		disponibilidadeAtualizado.get().setPeriodo(disponibilidade.getPeriodo());
		disponibilidadeAtualizado.get().setSala(disponibilidade.getSala());
				
		repository.save(disponibilidadeAtualizado.get());
		
		return Optional.ofNullable(disponibilidadeAtualizado.get());
	}

	public void remove(Long id) {
		repository.deleteById(id);
	}

}
