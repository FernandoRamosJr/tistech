package ao.co.tistech.sampleScheduleApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ao.co.tistech.sampleScheduleApi.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Optional<Agendamento> findByDisponibilidadeId(Long idDisponibilidade);

}
