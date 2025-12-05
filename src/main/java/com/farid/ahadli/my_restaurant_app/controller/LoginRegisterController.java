package com.farid.ahadli.my_restaurant_app.controller;

import com.farid.ahadli.my_restaurant_app.model.dto.request.LoginRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.RegistrationRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantUser;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantUserRepository;
import com.farid.ahadli.my_restaurant_app.service.LoginRegisterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginRegisterController {

LoginRegisterService loginRegisterService;

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {


    loginRegisterService.login(loginRequestDTO);

    return ResponseEntity.status(HttpStatus.OK)
            .body("Login successful");

}


    @PostMapping ("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequestDTO registrationRequestDTO) {
        loginRegisterService.register(registrationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registration successful");

    }
}
