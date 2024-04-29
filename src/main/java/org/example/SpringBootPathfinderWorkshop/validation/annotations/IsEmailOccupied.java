package org.example.SpringBootPathfinderWorkshop.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.SpringBootPathfinderWorkshop.validation.validator.ConfirmEmailAddressNotOccupied;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmEmailAddressNotOccupied.class)
@Documented
public @interface IsEmailOccupied {

    String message() default "Email address already exists. Enter new email address.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
