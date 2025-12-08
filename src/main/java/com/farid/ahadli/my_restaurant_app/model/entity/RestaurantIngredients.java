package com.farid.ahadli.my_restaurant_app.model.entity;

import com.farid.ahadli.my_restaurant_app.model.MeasureUnits;
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
@Builder
public class RestaurantIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    Boolean Allergen;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "menu_ingredient",
            joinColumns =@JoinColumn(name = "ingredient_id"),
            inverseJoinColumns =   @JoinColumn(name = "menu_id")
    )
    Set<RestaurantMenuItem> menuItemSet = new HashSet<>();

    public void addMenuItem(RestaurantMenuItem menuItem) {
        menuItemSet.add(menuItem);
        menuItem.addIngredientSet(this);
    }

    @Column(nullable = false,name = "unit")
    MeasureUnits measureUnits;

    @Column(nullable = false,name = "price_per_unit")
    Double pricePerUnit;





}
