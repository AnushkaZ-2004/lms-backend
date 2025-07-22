package com.lms.auth.service;

import com.lms.auth.model.User;
import com.lms.auth.model.UserRole;
import com.lms.auth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User register(String fullName, String email, String password, String role) {
        if (userRepo.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User(
                fullName,
                email,
                passwordEncoder.encode(password),
                UserRole.valueOf(role.toUpperCase())
        );

        return userRepo.save(user);
    }

    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }
}
