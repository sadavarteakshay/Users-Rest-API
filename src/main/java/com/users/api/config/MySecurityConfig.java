package com.users.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http
		.csrf().disable()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		auth
		.inMemoryAuthentication()
		.withUser("admin")
		.password(this.passwordEncoder().encode("12345"))
		.roles("ADMIN");
		
		auth
		.inMemoryAuthentication()
		.withUser("akshay")
		.password(this.passwordEncoder().encode("12345"))
		.roles("NORMAL");
			
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	
		return new BCryptPasswordEncoder(10);	
			
	}
	
	
	
}
