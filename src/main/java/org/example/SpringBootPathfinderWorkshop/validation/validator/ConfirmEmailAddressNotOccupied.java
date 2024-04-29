package org.example.SpringBootPathfinderWorkshop.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.example.SpringBootPathfinderWorkshop.validation.annotations.IsEmailOccupied;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmEmailAddressNotOccupied implements ConstraintValidator<IsEmailOccupied, String> {

    private final UserRepository userRepository;

    @Autowired
    public ConfirmEmailAddressNotOccupied(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void initialize(IsEmailOccupied constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isExist(value);
    }

    private boolean isExist(String email) {

        return this.userRepository.findByEmail(email).isEmpty();

    }
}
