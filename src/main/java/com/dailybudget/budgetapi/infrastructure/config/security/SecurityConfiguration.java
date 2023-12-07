package com.dailybudget.budgetapi.infrastructure.config.security;

import com.dailybudget.budgetapi.infrastructure.config.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest ->
                        authRequest.requestMatchers("/user/**").permitAll()
                                .anyRequest().authenticated()
                ).sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                ))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


/*
    @Value("${app.security.username}")
    private String username;

    @Value("${app.security.password}")
    private String password;

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder){
        UserDetails user= User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }



    @Bean
    public CategoryDomainService categoryDomainService(CategoryRepository categoryRepository) {
        return new CategoryDomainService(categoryRepository);
    }

    @Bean
    public UserInfoDomainService userInfoDomainService(UserInfoRepository userInfoRepository) {
        return new UserInfoDomainService(userInfoRepository);
    }

    @Bean
    public UserLoginDomainService userLoginDomainService(UserLoginRepository userLoginRepository) {
        return new UserLoginDomainService(userLoginRepository);
    }*/

}
