package org.sid.web;

import org.sid.dao.AppUserRepository;
import org.sid.entities.AppUser;
import org.sid.service.*;

import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



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
    
    
    
    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
	public Boolean confirmUserAccount( @RequestParam("token")String confirmationToken)
	{
		AppUser User = appUserRepository.findByConfirmationToken(confirmationToken);
		Boolean resultat=false;
		
		if(User != null)
		{
			
			User.setActived(true);
			appUserRepository.save(User);
			resultat=true;
			System.out.println(" user ! =null ");
		//	modelAndView.setViewName("accountVerified");
		}
		else
		{
			System.out.println(" user = =null ");

			//modelAndView.addObject("message","The link is invalid or broken!");
			//modelAndView.setViewName("error");
		}
		
		return resultat;
	}
}
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
    private String email;
    private String confirmationToken;

    
	public UserForm() {
		super();
	}
	
	


	public UserForm(String username, String password, String confirmedPassword, String email,
			String confirmationToken) {
		super();
		this.username = username;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
		this.email = email;
		this.confirmationToken = confirmationToken;
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
