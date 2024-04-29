package org.example.SpringBootPathfinderWorkshop.service;


import org.example.SpringBootPathfinderWorkshop.model.entity.UserEntity;
import org.example.SpringBootPathfinderWorkshop.model.service.UserServiceModel;
import org.example.SpringBootPathfinderWorkshop.model.view.UserProfileViewModel;

public interface UserService {

    void saveUser(UserServiceModel userServiceModel);

    UserProfileViewModel selectCurrentUser(String username);

    UserEntity selectUserEntityByUsername(String username);
}
