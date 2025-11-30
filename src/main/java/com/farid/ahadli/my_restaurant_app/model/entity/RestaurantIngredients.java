package com.farid.ahadli.my_restaurant_app.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    Boolean ifAllergen;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "menu_ingredient",
            joinColumns =@JoinColumn(name = "ingredient_id"),
            inverseJoinColumns =   @JoinColumn(name = "menu_id")
    )
    public Set<RestaurantMenuItem> menuItemSet = new HashSet<>();

    public void addMenuItem(RestaurantMenuItem menuItem) {
        menuItemSet.add(menuItem);
        menuItem.addIngredientSet(this);
    }




}
