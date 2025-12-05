package com.farid.ahadli.my_restaurant_app.service;

import com.farid.ahadli.my_restaurant_app.model.RestaurantUserRoles;
import com.farid.ahadli.my_restaurant_app.model.dto.request.LoginRequestDTO;
import com.farid.ahadli.my_restaurant_app.model.entity.RestaurantUser;
import com.farid.ahadli.my_restaurant_app.repository.RestaurantUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RestaurantUserDetailsService implements UserDetailsService {

    RestaurantUserRepository restaurantUserRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        RestaurantUser restaurantUser = restaurantUserRepository.findByUsername(username);
        if(Objects.isNull(restaurantUser)) {
            throw new UsernameNotFoundException(username);
        }

        return User.withUsername(restaurantUser.getUsername())
                .password(restaurantUser.getPassword())
                .roles(restaurantUser.getRoles().getRole())
                .build();
    }



}
