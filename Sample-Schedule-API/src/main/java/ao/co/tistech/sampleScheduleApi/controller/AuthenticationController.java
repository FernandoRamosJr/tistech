package ao.co.tistech.sampleScheduleApi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.co.tistech.sampleScheduleApi.config.security.TokenService;
import ao.co.tistech.sampleScheduleApi.dto.TokenDto;
import ao.co.tistech.sampleScheduleApi.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
    private AuthenticationManager authManager;
	
    @Autowired
    private TokenService tokenService;
    
    private static String password;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form) {
        password = form.getPassword();
        UsernamePasswordAuthenticationToken loginData = form.convert();

        try {
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    public static String getPassword() {
        return password;
    }
}
