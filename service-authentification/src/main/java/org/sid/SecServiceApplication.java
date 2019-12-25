package org.sid;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.AppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;

import org.sid.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountService accountService,AppUserRepository appUserRepository,AppRoleRepository appRoleRepository){
        return args->{
        	/*appRoleRepository.deleteAll();
        	appUserRepository.deleteAll();

        	AppRole ADMIN= new AppRole(null,"ADMIN", new ArrayList<AppUser>());
        	AppRole ABONNES= new AppRole(null,"ABONNE", new ArrayList<AppUser>());
        	AppRole BO= new AppRole(null,"BO",new ArrayList<AppUser>());
        	accountService.save(ADMIN);accountService.save(ABONNES);accountService.save(BO);
        	

            AppUser user1=accountService.saveUser("bo","1234","1234","user1@gmail.com");
            AppUser user2=accountService.saveUser("abonne","1234","1234","user2@gmail.com");
            AppUser admin=accountService.saveUser("admin","1234","1234","admin@gmail.com");
            
            
            accountService.addRoleToUser(user1.getIdUser(), "BO");
            accountService.addRoleToUser(user2.getIdUser(), "ABONNE");
            accountService.addRoleToUser(admin.getIdUser(),"ADMIN");*/
           
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}

