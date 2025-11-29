package com.farid.ahadli.my_restaurant_app.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "menu")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class RestaurantMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Double price;

    @ManyToMany
    @JoinTable(
            name = "menu_ingridient",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "ingridient_id")
    )
    public Set<RestaurantIngredients> ingredientSet =  new HashSet<>()  ;

    public void addIngredientSet( RestaurantIngredients ingredient ) {
        ingredientSet.add( ingredient );
        ingredient.addMenuItem( this );


    }




}
