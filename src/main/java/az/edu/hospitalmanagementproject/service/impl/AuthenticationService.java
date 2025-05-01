package az.edu.hospitalmanagementproject.service.impl;

import az.edu.hospitalmanagementproject.dto.auth.AuthenticationRequest;
import az.edu.hospitalmanagementproject.dto.auth.AuthenticationResponse;
import az.edu.hospitalmanagementproject.dto.auth.RegisterRequest;
import az.edu.hospitalmanagementproject.repository.UserRepository;
import az.edu.hospitalmanagementproject.security.JWTService;
import az.edu.hospitalmanagementproject.user.Role;
import az.edu.hospitalmanagementproject.user.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder().firstname(registerRequest.getFirstname()).lastname(registerRequest.getLastname()).email(registerRequest.getEmail()).password(this.passwordEncoder.encode(registerRequest.getPassword())).role(Role.USER).build();
        this.userRepository.save(user);
        String jwtToken = this.jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        User user = (User)this.userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        String jwtToken = this.jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
