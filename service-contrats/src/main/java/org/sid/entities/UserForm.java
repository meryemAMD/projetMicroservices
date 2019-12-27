package org.sid.entities;

public class UserForm {
	private String username;
    private String password;
    private String confirmedPassword;
    private String email;
    private String confirmationToken;
    private String  role;
    
	public UserForm() {
		super();
	}
	

	public UserForm(String username, String password, String confirmedPassword, String email, String confirmationToken,
			String role) {
		super();
		this.username = username;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
		this.email = email;
		this.confirmationToken = confirmationToken;
		this.role = role;
	}


	public String getConfirmationToken() {
		return confirmationToken;
	}





	public String getRole() {
		return role;
	}







	public void setRole(String role) {
		this.role = role;
	}







	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
