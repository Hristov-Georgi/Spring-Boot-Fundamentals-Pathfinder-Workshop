package org.example.SpringBootPathfinderWorkshop.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.example.SpringBootPathfinderWorkshop.validation.annotations.IsUsernameOccupied;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmUsernameNotOccupied implements ConstraintValidator<IsUsernameOccupied, String> {

    private final UserRepository userRepository;

    @Autowired
    public ConfirmUsernameNotOccupied(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(IsUsernameOccupied constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return validateUsername(value);
    }

    private boolean validateUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }
}
