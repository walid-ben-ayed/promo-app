package com.promo.api.controller;

import com.promo.api.dto.AuthRequest;
import com.promo.api.dto.AuthResponse;
import com.promo.api.dto.RegisterRequest;
import com.promo.api.mapper.UserDtoMapper;
import com.promo.api.security.JwtService;
import com.promo.application.service.AuthService;
import com.promo.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;
    private final UserDtoMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        User user = mapper.toDomain(request);
        User registered = authService.register(user);
        String token = jwtService.generateToken(registered.getEmail());
        
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(AuthResponse.builder()
                .token(token)
                .email(registered.getEmail())
                .role(registered.getRole().name())
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        User user = authService.authenticate(request.getEmail(), request.getPassword());
        String token = jwtService.generateToken(user.getEmail());
        
        return ResponseEntity.ok(AuthResponse.builder()
            .token(token)
            .email(user.getEmail())
            .role(user.getRole().name())
            .build());
    }
}
