package com.example.userConsumer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails sajjad = User.builder()
                .username("sajjad")
                .password("{noop}1234")
                .roles("CUSTOMER")
                .build();

        UserDetails zahra = User.builder()
                .username("zahra")
                .password("{noop}1234")
                .roles("CUSTOMER", "ADMIN")
                .build();

        UserDetails maede = User.builder()
                .username("maede")
                .password("{noop}1234")
                .roles("CUSTOMER", "ADMIN", "SUPER")
                .build();

        return new InMemoryUserDetailsManager(sajjad, zahra, maede);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
        );

        // use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross SIte Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
