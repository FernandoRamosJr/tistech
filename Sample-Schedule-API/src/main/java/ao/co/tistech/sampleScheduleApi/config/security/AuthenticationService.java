package ao.co.tistech.sampleScheduleApi.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ao.co.tistech.sampleScheduleApi.model.Candidato;
import ao.co.tistech.sampleScheduleApi.repository.CandidatoRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
    CandidatoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Candidato> candidato = repository.findByEmail(username);
		if (candidato.isPresent()) {
            return candidato.get();
        }
		throw new UsernameNotFoundException("Dados inválidos");
	}

}
