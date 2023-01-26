package com.sdjr2.rest_sp5_ztoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
* Config Spring Security Internal to manager security.
*
* @author jroldan
* @version 1.0
* @since 23/01/26
* @category Bean
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService users() {
		// The builder will ensure the passwords are encoded before saving in memory
		UserDetails user = User.builder()
			.username("user")
			.password(this.passwordEncoder().encode("password"))
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password(this.passwordEncoder().encode("password"))
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/users/**").hasRole("ADMIN")
			.requestMatchers("/roles/**").permitAll().anyRequest().authenticated()
			.and()
        	.httpBasic();
	    return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		/*
		 * Use {bcrypt} for BCryptPasswordEncoder
		 * Use {noop} for NoOpPasswordEncoder
		 * Use {pbkdf2} for Pbkdf2PasswordEncoder
		 * Use {scrypt} for SCryptPasswordEncoder
		 * Use {sha256} for StandardPasswordEncoder
		*/
		return new BCryptPasswordEncoder();
	}
	
}