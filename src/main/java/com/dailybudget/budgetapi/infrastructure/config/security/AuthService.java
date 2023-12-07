package com.dailybudget.budgetapi.infrastructure.config.security;

import com.dailybudget.budgetapi.domain.user.models.dto.LoginRequest;
import com.dailybudget.budgetapi.infrastructure.config.security.jwt.JwtService;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import com.dailybudget.budgetapi.infrastructure.user.adapters.repositories.UserLoginJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserLoginJpaRepository userLoginJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserLoginEntity user = userLoginJpaRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }
}
