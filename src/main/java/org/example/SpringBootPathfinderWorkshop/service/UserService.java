package org.example.SpringBootPathfinderWorkshop.service;


import org.example.SpringBootPathfinderWorkshop.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel validateUser(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    boolean isUsernameExists(String username);

    void saveUser(UserServiceModel userServiceModel);
}
