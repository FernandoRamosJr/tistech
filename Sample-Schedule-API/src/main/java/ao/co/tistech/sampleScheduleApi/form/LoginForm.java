package ao.co.tistech.sampleScheduleApi.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class LoginForm {
	private String user;
    private String password;
    
    public LoginForm() {}

    public LoginForm(String user, String password) {
		this.user = user;
		this.password = password;
	}
    
    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(user, password);
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
