package com.dailybudget.budgetapi.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

//no in production
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
            UserDetails user= User.withDefaultPasswordEncoder().username("user")
                .password("password").roles("USER").build();

            return new InMemoryUserDetailsManager(user);

    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        auth -> {
                            auth.requestMatchers("/**").permitAll();
                           // auth.requestMatchers("/user").hasRole("USER");
                        }
                )
                .httpBasic(Customizer.withDefaults()).build();
    }

}
