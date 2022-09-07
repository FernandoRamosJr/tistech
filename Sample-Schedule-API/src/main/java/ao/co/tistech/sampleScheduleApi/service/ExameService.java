package ao.co.tistech.sampleScheduleApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.co.tistech.sampleScheduleApi.model.Exame;
import ao.co.tistech.sampleScheduleApi.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
    ExameRepository repository;
	
	public Optional<List<Exame>> getListaExame() {
        Optional<List<Exame>> listaExames = Optional.of(repository.findAll());
        return listaExames;
    }
	
    public Optional<Exame> getExameId(Long idExame) {
        Optional<Exame> exame = repository.findById(idExame);
        return exame;
    }

	public void criarExame(Exame exame) {
		repository.save(exame);		
	}
	
	public Optional<Exame> atualiza(Exame exame) {
		Optional<Exame> exameAtualizado = repository.findById(exame.getId());
		
		exameAtualizado.get().setNome(exame.getNome());
		exameAtualizado.get().setDescricao(exame.getDescricao());
		
		repository.save(exameAtualizado.get());
		
		return Optional.ofNullable(exameAtualizado.get());
	}

	public void remove(Long id) {
		repository.deleteById(id);
	}

}
