package ao.co.tistech.sampleScheduleApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.co.tistech.sampleScheduleApi.model.Agendamento;
import ao.co.tistech.sampleScheduleApi.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
    AgendamentoRepository repository;
	
	public Optional<List<Agendamento>> getListaAgendamento() {
        Optional<List<Agendamento>> listaAgendamentos = Optional.of(repository.findAll());
        return listaAgendamentos;
    }
	
    public Optional<Agendamento> getAgendamentoId(Long idAgendamento) {
        Optional<Agendamento> agendamento = repository.findById(idAgendamento);
        return agendamento;
    }
    
    public Optional<Agendamento> getAgendamentoPorDisponibilidadeId(Long idDisponibilidade) {
        Optional<Agendamento> agendamento = repository.findByDisponibilidadeId(idDisponibilidade);
        return agendamento;
    }

	public void criarAgendamento(Agendamento agendamento) {
		repository.save(agendamento);		
	}
	
	public Optional<Agendamento> atualiza(Agendamento agendamento) {
		Optional<Agendamento> agendamentoAtualizado = repository.findById(agendamento.getId());
		
		agendamentoAtualizado.get().setCandidato(agendamento.getCandidato());
		agendamentoAtualizado.get().setExame(agendamento.getExame());
		agendamentoAtualizado.get().setDisponibilidade(agendamento.getDisponibilidade());
				
		repository.save(agendamentoAtualizado.get());
		
		return Optional.ofNullable(agendamentoAtualizado.get());
	}

	public void remove(Long id) {
		repository.deleteById(id);
	}

}
