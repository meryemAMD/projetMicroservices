package org.sid.service;

import java.util.UUID;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.AppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private EmailSenderService emailSenderService;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword,String email) {
        
    	String confirmationToken = UUID.randomUUID().toString();

    	AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
       // appUser.setActived(false);
        appUser.setActived(true);

        appUser.setEmail(email);
        appUser.setConfirmationToken(confirmationToken);
        System.out.println(" confirmatuon token "+ appUser.getConfirmationToken());
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);

        addRoleToUser(username,"USER");
        
    /*	SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(appUser.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom("project4ann.2019@gmail.com");
		mailMessage.setText("To confirm your account, please click here : "
		+"http://localhost:4200/#/login?token="+appUser.getConfirmationToken());
		
		emailSenderService.sendEmail(mailMessage);*/
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        
       // System.out.println(" rolename "+rolename+"  "+appRole.getId());
        //System.out.println(" appUser "+appUser.getId());
       
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser);

   

     //   System.out.println(appUser.getUsername()+" "+appUser.getRoles().size());

        
    }
}
