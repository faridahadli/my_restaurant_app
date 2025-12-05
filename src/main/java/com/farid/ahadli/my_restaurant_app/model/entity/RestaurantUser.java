package com.farid.ahadli.my_restaurant_app.model.entity;

import com.farid.ahadli.my_restaurant_app.model.RestaurantUserRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @NotEmpty
    @Column(unique = true,
            nullable = false)
    String username;

    @NotEmpty
    @Column(nullable = false)
    String password;

    @OneToOne(fetch = FetchType.EAGER)
    RestaurantRoles roles;

}
