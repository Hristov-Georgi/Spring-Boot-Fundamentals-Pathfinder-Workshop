package org.example.SpringBootPathfinderWorkshop.model.binding;

import jakarta.validation.constraints.*;
import org.example.SpringBootPathfinderWorkshop.validation.annotations.ArePasswordsEqual;
import org.example.SpringBootPathfinderWorkshop.validation.annotations.IsEmailOccupied;
import org.example.SpringBootPathfinderWorkshop.validation.annotations.IsUsernameOccupied;
import org.hibernate.validator.constraints.Length;

@ArePasswordsEqual
public class UserRegisterBindingModel {


    @NotBlank
    @IsUsernameOccupied
    @Length(min = 4, max = 20, message = "Username must be between 4 and 20 symbols.")
    private String username;

    @NotBlank
    @Length(min = 5, max = 20, message = "Full name must be between 5 and 20 symbols.")
    private String fullName;


    @Email(message = "Enter valid email address.")
    @IsEmailOccupied
    private String email;

    @NotNull
    @Min(value = 0, message = "Age must be between 0 and 90.")
    @Max(value = 90, message = "Age must be between 0 and 90.")
    private int age;

    @NotBlank
    @Length(min = 5, max = 20, message = "Password must be between 4 and 20 symbols.")
    private String password;

    @NotBlank(message = "Passwords should match.")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
