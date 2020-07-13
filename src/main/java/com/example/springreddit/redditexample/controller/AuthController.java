package com.example.springreddit.redditexample.controller;


import com.example.springreddit.redditexample.dto.AuthenticationResponse;
import com.example.springreddit.redditexample.dto.LoginRequest;
import com.example.springreddit.redditexample.dto.RefreshTokenRequest;
import com.example.springreddit.redditexample.dto.RegisterRequest;
import com.example.springreddit.redditexample.service.AuthService;
import com.example.springreddit.redditexample.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest ){
        authService.signup(registerRequest);
        return new ResponseEntity<>("User Registration Succesfuly", HttpStatus.OK);
    }

   @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> virifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully", HttpStatus.OK);

   }

   @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
       return  authService.login(loginRequest);

   }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {

        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
    }



}
