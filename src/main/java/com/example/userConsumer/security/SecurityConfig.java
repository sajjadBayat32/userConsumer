package com.example.userConsumer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
}
