package org.example.SpringBootPathfinderWorkshop.model;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {

    @NotBlank
    @Length(min = 4, max =20, message = "Username length should be between 4 and 20 symbols.")
    private String username;

    @NotBlank
    @Length(min = 4, max = 20, message = "Password length should be between 4 and 20 symbols.")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
