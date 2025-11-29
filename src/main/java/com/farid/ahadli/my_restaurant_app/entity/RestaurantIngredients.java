package com.farid.ahadli.my_restaurant_app.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingridients")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class RestaurantIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    Boolean ifAllergen;

    @ManyToMany
    @JoinTable(
            name = "menu_ingridient",
            joinColumns =@JoinColumn(name = "ingridient_id"),
            inverseJoinColumns =   @JoinColumn(name = "menu_id")
    )
    public Set<RestaurantMenuItem> menuItemSet = new HashSet<>();

    public void addMenuItem(RestaurantMenuItem menuItem) {
        menuItemSet.add(menuItem);
        menuItem.addIngredientSet(this);
    }




}
