package com.farid.ahadli.my_restaurant_app.validation;

import com.farid.ahadli.my_restaurant_app.model.TableEnum;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ProperTableValidator.class)
public @interface ProperTable {

    TableEnum [] allowedTables() default {};
    String message() default "invalid table";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
