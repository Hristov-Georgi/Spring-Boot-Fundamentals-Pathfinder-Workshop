package org.example.SpringBootPathfinderWorkshop.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.SpringBootPathfinderWorkshop.validation.validator.ConfirmPasswordsEqual;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmPasswordsEqual.class)
@Documented
public @interface ArePasswordsEqual {

    String message() default "Passwords does not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
