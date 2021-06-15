package com.karthik.springcloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.karthik.springcloud.security.UserDetailsServiceImpl;


//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.httpBasic();
		//http.formLogin();
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/couponapi/coupons","/index","/showGetCoupon","/getCoupon","couponDetails")
		.hasAnyRole("USER", "ADMIN")
		.mvcMatchers(HttpMethod.GET, "/createCoupon","/showCreateCoupon","/CreateReponse").hasRole("ADMIN")
		.mvcMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("ADMIN","USER")
		.mvcMatchers(HttpMethod.POST, "/couponapi/coupons","/saveCoupon","/getCoupon").hasRole("ADMIN")
		.mvcMatchers("/","/login","/logout","/showReg","/registerUser").permitAll().anyRequest().denyAll().and().csrf().disable().logout().logoutSuccessUrl("/");
		
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
}
