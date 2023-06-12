package com.sdjr2.rest_sp5_ztoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * {@link SecurityConfig} class.
 * <p>
* Config - Spring Security Internal to manager security.
*
* @author jroldan
* @version 1.0
* @category Bean
* @since 23/01/26
* @upgrade 23/01/30
*/
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

	// Security In Memory
	/*
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
	*/

	// Security level Controller
	@Bean
	SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeHttpRequests()
			.requestMatchers("/users/**").permitAll()
			//.requestMatchers("/users/**").hasRole("ADMIN")
			//.requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
			//.requestMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("DELETE_USER_AUTHORITY")
			//.requestMatchers(HttpMethod.DELETE, "/users/**").hasAnyAuthority("DELETE_ADMIN_AUTHORITY", "DELETE_USER_AUTHORITY")
			.requestMatchers("/roles/**").hasAnyRole("ADMIN", "USER")
			.anyRequest().authenticated()
			.and()
        	.httpBasic();
	    return http.build();
	}

	// Security encryption
	@Bean
	PasswordEncoder passwordEncoder() {
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
