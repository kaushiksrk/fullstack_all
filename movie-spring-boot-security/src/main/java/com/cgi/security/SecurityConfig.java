package com.cgi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public AuthenticationManager authenticationManager(
                                 AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
        .authorizeHttpRequests((authorize) ->authorize
        		.antMatchers("/auth/**").permitAll()
				//.antMatchers("/in/**").permitAll()
				.antMatchers(HttpMethod.GET, "/in/**").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/in/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/in/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.DELETE, "/in/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
        );
		
        return http.build();
    }
}
