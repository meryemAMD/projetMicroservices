package org.sid.proxies;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.sid.entities.UserForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("abonne")
//@RibbonClient(name = "abonne" , configuration = RibbonConfiguration.class)
@FeignClient(name="authentification-service", configuration=FeignConfiguration.class)
public interface FeignAuthentificationServiceClient {
	
	@PostMapping("/registerAndGetIdUser")
    public String registerAndGetIdUser(@RequestBody  UserForm userForm);
}
