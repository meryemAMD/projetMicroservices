package org.sid.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// a revoir 
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

       http.authorizeRequests().antMatchers(HttpMethod.GET,"/Comptes/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/Cartes/**").permitAll();

      http.authorizeRequests().antMatchers("/Comptes/**","/Cartes/**").hasAnyAuthority("ABONNE","BO");
     // http.authorizeRequests().antMatchers("/Comptes/**","/Cartes/**").hasAuthority("ABONNE");

       http.authorizeRequests().anyRequest().authenticated();
       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
