package com.farid.ahadli.my_restaurant_app.controller;

import com.farid.ahadli.my_restaurant_app.model.dto.request.LoginRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.RegistrationRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.RoleRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantUser;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantUserRepository;
import com.farid.ahadli.my_restaurant_app.service.LoginRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LoginRegisterController {

    LoginRegisterService loginRegisterService;

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO, HttpServletRequest request) {


    loginRegisterService.login(loginRequestDTO,request);

    return ResponseEntity.status(HttpStatus.OK)
            .body("Login successful");

}

    @PostMapping ("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequestDTO registrationRequestDTO) {
        loginRegisterService.register(registrationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registration successful");

    }

    @PostMapping ("/role")
    public ResponseEntity<?> addRole(@RequestBody @Valid RoleRequestDTO roleRequestDTO) {
        loginRegisterService.addRole(roleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("role added successfully");

    }


    @GetMapping("/username")
    public ResponseEntity<?> getAllUsernames() {
        return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.getAllUsername());
    }

    @GetMapping("/role")
    public ResponseEntity<?> getAllRoles() {
    return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.getAllRoles());
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<?> deleteUsername(@PathVariable String username) {
        loginRegisterService.deleteUser(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
