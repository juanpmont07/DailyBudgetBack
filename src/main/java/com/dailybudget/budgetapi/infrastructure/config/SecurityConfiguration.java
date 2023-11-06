package com.dailybudget.budgetapi.infrastructure.config;

import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import com.dailybudget.budgetapi.domain.repository.user.UserLoginRepository;
import com.dailybudget.budgetapi.domain.service.category.CategoryDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserLoginDomainService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${app.security.username}")
    private String username;

    @Value("${app.security.password}")
    private String password;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder){
        UserDetails user= User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests()
                    .requestMatchers("/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                .httpBasic()
                .and().build();
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
    }

}
