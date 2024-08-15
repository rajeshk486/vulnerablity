package com.sahaj.tambola.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    //Vulnerable CSRF disabled and allowing all request
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Example: Disabling CSRF protection
                .authorizeRequests(auth -> auth
                        .anyRequest().authenticated()  // Require authentication for all requests
                )
                .formLogin(login -> login
                        .permitAll()  // Allow everyone to access the login page
                );

        return http.build();
    }

}
