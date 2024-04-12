package org.example.SpringBootPathfinderWorkshop.service;


import org.example.SpringBootPathfinderWorkshop.model.UserLoginBindingModel;
import org.example.SpringBootPathfinderWorkshop.model.UserServiceModel;

public interface UserService {

    UserServiceModel validateUser(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();
}
