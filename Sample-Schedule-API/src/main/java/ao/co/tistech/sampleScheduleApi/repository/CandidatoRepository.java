package ao.co.tistech.sampleScheduleApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ao.co.tistech.sampleScheduleApi.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

	Optional<Candidato> findByEmail(String email);

}
