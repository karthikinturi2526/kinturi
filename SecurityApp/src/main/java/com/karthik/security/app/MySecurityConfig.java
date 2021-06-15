package com.karthik.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
	//this method is to provide custom user service userdetails
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * InMemoryUserDetailsManager userDetailsService = new
	 * InMemoryUserDetailsManager(); UserDetails user =
	 * User.withUsername("karthik").password(passwordEncoder.encode("inturi")).
	 * authorities("read").build(); userDetailsService.createUser(user);
	 * 
	 * auth.userDetailsService(userDetailsService);
	 * 
	 * }
	 */
	
	//this method we are using Authentication provider class "MyAuthenticationProvider" to provide user detais
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
	}
	
	
	// this method is to authenticate user with http security
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Basic Auth
		http.httpBasic();
		http.authorizeRequests().antMatchers("/hello").authenticated();
		http.addFilterAfter(new MySecurityFilter(), BasicAuthenticationFilter.class);
		//http.authorizeRequests().anyRequest().authenticated();
		// Formbased authetication and authenicate only particular url called and deny others
		//http.formLogin();
		//http.authorizeRequests().antMatchers("/hello").authenticated().anyRequest().denyAll();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

}
