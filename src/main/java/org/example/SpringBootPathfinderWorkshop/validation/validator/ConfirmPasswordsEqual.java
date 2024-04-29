package org.example.SpringBootPathfinderWorkshop.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.SpringBootPathfinderWorkshop.model.binding.UserRegisterBindingModel;
import org.example.SpringBootPathfinderWorkshop.validation.annotations.ArePasswordsEqual;

public class ConfirmPasswordsEqual implements ConstraintValidator<ArePasswordsEqual, UserRegisterBindingModel> {

    private String message;

    @Override
    public void initialize(ArePasswordsEqual constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegisterBindingModel value, ConstraintValidatorContext context) {
        return comparePasswords(value.getPassword(), value.getConfirmPassword(), context);
    }

    private boolean comparePasswords(String password, String confirmPassword, ConstraintValidatorContext context) {

        boolean areEqual = password != null && password.equals(confirmPassword);

        if(!areEqual) {

            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();

        }

        return areEqual;

    }
}
