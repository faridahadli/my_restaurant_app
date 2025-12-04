package com.farid.ahadli.my_restaurant_app.model.entity;

import com.farid.ahadli.my_restaurant_app.model.TaxType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
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
            name = "menu_ingredient",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    public Set<RestaurantIngredients> ingredientSet =  new HashSet<>() ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "tax_type")
    TaxType taxType;

    @Column(nullable = false, name = "tax_rate")
    Double taxRate;

    @Column(nullable = false, name = "tax_amount")
    Double taxAmount;



    public void addIngredientSet( RestaurantIngredients ingredient ) {
        ingredientSet.add( ingredient );
        ingredient.addMenuItem( this );
    }




}
