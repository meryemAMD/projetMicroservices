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
        /*	appRoleRepository.deleteAll();
        	appUserRepository.deleteAll();

            accountService.save(new AppRole(null,"USER", new ArrayList<AppUser>()));
            accountService.save(new AppRole(null,"ADMIN",new ArrayList<AppUser>()));
            Stream.of("user1","user2","user3","admin").forEach(un->{
                accountService.saveUser(un,"1234","1234",un+"@gmail.com");
                
            });

         
            accountService.addRoleToUser("admin","ADMIN");*/
           
        };
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }

}

