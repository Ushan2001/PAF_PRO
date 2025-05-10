package com.example.paf.controller;

import com.example.paf.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "Please use the frontend to initiate login";
    }

    @GetMapping("/dashboard")
    public UserDTO dashboard(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        return new UserDTO(
                principal.getAttribute("name"),
                principal.getAttribute("email"),
                principal.getAttribute("picture")
        );
    }
}