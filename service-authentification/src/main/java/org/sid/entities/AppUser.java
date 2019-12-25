package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Email;
@Document
@Data @AllArgsConstructor @NoArgsConstructor 

public class AppUser {
    @Id
    private String idUser;
    @Indexed(unique=true)
    private String username;
  //  @JsonIgnore
    private String password;
    private boolean actived;
    @Email
    private String email;
    @DBRef
    private Collection<AppRole> roles=new ArrayList<>();
    private String confirmationToken;

    
	public AppUser() {
		super();
	}
	public AppUser(String idUser, String username, String password, @Email String email, Collection<AppRole> roles) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}









	public AppUser(String idUser, String username, String password, boolean actived, @Email String email,
			Collection<AppRole> roles
			//, String confirmationToken
			) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.actived = actived;
		this.email = email;
		this.roles = roles;
	//	this.confirmationToken = confirmationToken;
	}











	public String getIdUser() {
		return idUser;
	}











	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}











	public String getConfirmationToken() {
		return confirmationToken;
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
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
