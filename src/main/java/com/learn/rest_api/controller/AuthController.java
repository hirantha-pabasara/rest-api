package com.learn.rest_api.controller;

import com.learn.rest_api.dto.request.LoginRequest;
import com.learn.rest_api.dto.request.SignupRequest;
import com.learn.rest_api.dto.response.JwtResponse;
import com.learn.rest_api.dto.response.MessageResponse;
import com.learn.rest_api.dto.response.UserProfileResponse;
import com.learn.rest_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> signup(@Valid @RequestBody SignupRequest request) {
        MessageResponse response = authService.signup(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signin(@Valid @RequestBody LoginRequest request) {
        JwtResponse response = authService.signin(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getProfile(@AuthenticationPrincipal UserDetails userDetails) {
        UserProfileResponse response = authService.getProfile(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }
}
