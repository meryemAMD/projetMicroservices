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

      //  addRoleToUser(username,"USER");
        
    	SimpleMailMessage mailMessage = new SimpleMailMessage();
    	
		mailMessage.setTo(appUser.getEmail());
		mailMessage.setSubject("Création de compte sur E-banking!");
		mailMessage.setFrom("project4ann.2019@gmail.com");
		mailMessage.setText("Bonjour,"+appUser.getUsername()+"\n Votre compte sur l'espace Ebanking a été crée.  \n"
				+ "Visitez le lien suivant pour changer votre mot de passe en utilisant le lien suivant: http://localhost:4200/#/change-password?token="+appUser.getConfirmationToken()+"."
						+ "\n Utiliser les informations suivantes:  \n  -Nom d'utilisateur "+appUser.getUsername()+
				" \n -Code d'accès :"+appUser.getConfirmationToken());
		//mailMessage.setText("Bonjour,http://localhost:4200/#/change-password?token="+appUser.getConfirmationToken());
				//appUser.getConfirmationToken())
		emailSenderService.sendEmail(mailMessage);
		
		
		
        return appUser;
    }

	@Override
	public AppUser ChangePassword(String username, String password, String confirmedPassword,
			String confirmationToken) {
		// TODO Auto-generated method stub
		
		AppUser  user=appUserRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("User doesn't exist!");
        else {
        	 if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        	 else  if(!confirmationToken.equals(user.getConfirmationToken())) throw new RuntimeException("Acces Code is invalid !");
        	 else   if(!username.equals(user.getUsername())) throw new RuntimeException("Username is invalid !");
        	 else {
             user.setPassword(bCryptPasswordEncoder.encode(password));
             user.setConfirmationToken("");
             appUserRepository.save(user);
         	SimpleMailMessage mailMessage = new SimpleMailMessage();
    		mailMessage.setTo(user.getEmail());
    		mailMessage.setSubject("Modification de mot de passe!");
    		mailMessage.setFrom("project4ann.2019@gmail.com");
    		mailMessage.setText("Bonjour,"+user.getUsername()+" \n Votre mot de passe a été changé ");
    				//appUser.getConfirmationToken())
    		
    		emailSenderService.sendEmail(mailMessage);
        	 }
        }
       
        

		return user;
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
    public void addRoleToUser(String idUser, String rolename) {
        AppUser appUser=appUserRepository.findByIdUser(idUser);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        System.out.println("User "+appUser.getUsername());
        System.out.println("Role "+appRole.getRoleName());

       // System.out.println(" rolename "+rolename+"  "+appRole.getId());
        //System.out.println(" appUser "+appUser.getId());
       if(appUser!=null && appRole!=null) {
    	   
    	   appUser.getRoles().add(appRole);
           appUserRepository.save(appUser);  
       }
       else 
         throw new RuntimeException("User or Role Doesn't exist!");

   

     //   System.out.println(appUser.getUsername()+" "+appUser.getRoles().size());

        
    }

	@Override
	public AppUser saveUserWithRole(String username, String password, String confirmedPassword, String email,
			String RoleName) {
		String confirmationToken = UUID.randomUUID().toString();

    	AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);

        appUser.setEmail(email);
        appUser.setConfirmationToken(confirmationToken);
        System.out.println(" confirmatuon token "+ appUser.getConfirmationToken());
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);

       addRoleToUser(appUser.getIdUser(),RoleName);
  
        return appUser;
	}


}
