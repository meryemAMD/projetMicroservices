package org.sid.web;

import java.util.ArrayList;
import java.util.Collection;

import org.sid.dao.AppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.service.*;

import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin(origins = "*")

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AppUserRepository appUserRepository;
	
    @PostMapping("/register")
    public AppUser register(@RequestBody  UserForm userForm){
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getEmail());
    }
    
    @PostMapping("/registerAndGetIdUser")
    public String registerAndGetIdUser(@RequestBody  UserForm userForm){
       return  accountService.saveUserWithRole(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getEmail(),userForm.getRole()).getIdUser();
    }
    
    @PostMapping("/Register")
    public AppUser Register(@RequestBody  UserForm userForm){
        return  accountService.saveUserWithRole(
                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword(),userForm.getEmail(),userForm.getRole());
    }
    
    @PostMapping("/AddRoleToUser")
    public void AddRole(@RequestBody  RoleForm roleForm){
          accountService.addRoleToUser(roleForm.getIdUser(), roleForm.getRole());
    }

    
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public AppUser confirmUserAccount(@RequestBody  ChangePassword changePassword)
	{
		
		
		return accountService.ChangePassword( changePassword.getUsername(),changePassword.getPassword() , changePassword.getConfirmedPassword(),changePassword.getConfirmationToken());
	}
}
class UserForm{
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

class RoleForm{
    private String idUser;
    private String role;
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RoleForm(String idUser, String role) {
		super();
		this.idUser = idUser;
		this.role = role;
	}
	public RoleForm() {
		super();
	}

}

class ChangePassword{

	   private String username;
	    private String password;
	    private String confirmedPassword;
	    private String confirmationToken;
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
		public String getConfirmationToken() {
			return confirmationToken;
		}
		public void setConfirmationToken(String confirmationToken) {
			this.confirmationToken = confirmationToken;
		}
		public ChangePassword(String username, String password, String confirmedPassword, String confirmationToken) {
			super();
			this.username = username;
			this.password = password;
			this.confirmedPassword = confirmedPassword;
			this.confirmationToken = confirmationToken;
		}
		public ChangePassword() {
			super();
		}
	    
}

