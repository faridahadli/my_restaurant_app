package com.farid.ahadli.my_restaurant_app.service;


import com.farid.ahadli.my_restaurant_app.model.dto.request.LoginRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.RegistrationRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.dto.request.RoleRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantRoles;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantUser;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantRoleRepository;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantUserRepository;
import com.farid.ahadli.my_restaurant_app.utility.GlobalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class LoginRegisterService {

    AuthenticationManager authenticationManager;
    RestaurantUserRepository restaurantUserRepository;
    RestaurantRoleRepository restaurantRoleRepository;
    PasswordEncoder passwordEncoder;

    public void login(LoginRequestDTO loginRequestDTO, HttpServletRequest request) {


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
        );

        System.out.println(authentication);


    }

    public void register(RegistrationRequestDTO  registrationRequestDTO) {
        RestaurantUser user  = restaurantUserRepository.findByUsername(registrationRequestDTO.getUsername());
        System.out.println(user);
        GlobalUtil.ifUserExist(user);
        RestaurantRoles user_role = restaurantRoleRepository.findByRole(registrationRequestDTO.getRoles());
        GlobalUtil.ifRoleExists(user_role);

        RestaurantUser restaurantUser = RestaurantUser.builder()
                .username(registrationRequestDTO.getUsername())
                .password(passwordEncoder.encode(registrationRequestDTO.getPassword()))
                .roles(restaurantRoleRepository.findByRole(registrationRequestDTO.getRoles()))
                .build();

        System.out.println(restaurantUser);

        restaurantUserRepository.save(restaurantUser);


    }


    public void addRole( RoleRequestDTO roleRequestDTO) {
        RestaurantRoles role = restaurantRoleRepository.findByRole(roleRequestDTO.getRole());
        GlobalUtil.ifRoleAbsent(role);
        RestaurantRoles newRole = new RestaurantRoles();
        newRole.setRole(roleRequestDTO.getRole());
        restaurantRoleRepository.save(newRole);
    }


    public Set<String> getAllUsername(){
        return restaurantUserRepository.findAllReturnUsernames();
    }


    public Set<String> getAllRoles(){
        return restaurantRoleRepository.findAllReturnRole();
    }


    @Transactional
    public void deleteUser( String username){
        restaurantUserRepository.deleteByUsername(username);
    }






}
