package ao.co.tistech.sampleScheduleApi.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import ao.co.tistech.sampleScheduleApi.model.Candidato;
import ao.co.tistech.sampleScheduleApi.repository.CandidatoRepository;

public class AuthenticationViaTokenFilter extends OncePerRequestFilter {
	
	private TokenService tokenService;
	
	private CandidatoRepository repository;
	
	public AuthenticationViaTokenFilter(TokenService tokenService, CandidatoRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recoverToken(request);
        boolean valid = tokenService.isTokenValid(token);
        if (valid) {
            authenticateClient(token);
        }
        filterChain.doFilter(request, response);
		
	}
	
	private String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
	
	private void authenticateClient(String token) {
        Long candidatoId = tokenService.getCandidatoId(token);
        Candidato candidato = repository.findById(candidatoId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(candidato, null, candidato.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
