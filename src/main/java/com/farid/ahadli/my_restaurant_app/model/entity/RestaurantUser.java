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
@Table(name = "restaurant_user")
@ToString
public class RestaurantUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @NotEmpty
    @Column(
            nullable = false)
    String username;

    @NotEmpty
    @Column(nullable = false)
    String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    RestaurantRoles roles;

}
