package com.lms.auth.controller;

import com.lms.auth.model.User;
import com.lms.auth.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> body) {
        return authService.register(
                body.get("fullName"),
                body.get("email"),
                body.get("password"),
                body.get("role")
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body, HttpSession session) {
        var user = authService.login(body.get("email"), body.get("password"));
        if (user.isPresent()) {
            session.setAttribute("user", user.get());
            return "Login success!";
        }
        return "Invalid email or password";
    }

    @GetMapping("/me")
    public Object getCurrentUser(HttpSession session) {
        return session.getAttribute("user");
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged out successfully";
    }
}
