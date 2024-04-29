package org.example.SpringBootPathfinderWorkshop.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.SpringBootPathfinderWorkshop.validation.validator.ConfirmUsernameNotOccupied;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmUsernameNotOccupied.class)
@Documented
public @interface IsUsernameOccupied {

    String message() default "Username is occupied. Please enter new username.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
