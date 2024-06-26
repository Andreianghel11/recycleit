package com.project.recycleit.services;

import com.project.recycleit.authentication.AuthenticationRequest;
import com.project.recycleit.authentication.AuthenticationResponse;
import com.project.recycleit.authentication.RegisterRequest;
import com.project.recycleit.beans.Role;
import com.project.recycleit.beans.User;
import com.project.recycleit.configs.JwtService;
import com.project.recycleit.exceptionHandler.UserExistsException;
import com.project.recycleit.repositories.UserRepository;
import com.project.recycleit.utils.WasteTypes;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserAchievementService userAchievementService;

    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserExistsException("User already exists");
        }

        User user = null;
        if (request.getEmail().contains("recycleit")) {
            user = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getFirstname(), request.getLastname(), Role.ADMIN);
        } else {
            user = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()), request.getFirstname(), request.getLastname());
        }

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        // When a new user is created, the list of achievements is also created for that user
        userAchievementService.createNewUserAchievements(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
