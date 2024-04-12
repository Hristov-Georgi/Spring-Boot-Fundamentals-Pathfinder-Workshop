package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.entity.User;
import org.example.SpringBootPathfinderWorkshop.model.UserLoginBindingModel;
import org.example.SpringBootPathfinderWorkshop.model.UserServiceModel;
import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.example.SpringBootPathfinderWorkshop.security.CurrentUser;
import org.example.SpringBootPathfinderWorkshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public UserServiceModel validateUser(String username, String password) {
        Optional<User> user = this.userRepository.findByUsername(username);

        if(user.isPresent() && confirmPassword(password, user.get().getPassword())) {
            return this.modelMapper.map(user, UserServiceModel.class);
        }

        return null;
    }

    private boolean confirmPassword(String rawPassword, String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        this.currentUser.setUsername(userServiceModel.getUsername());
        this.currentUser.setId(userServiceModel.getId());
        this.currentUser.setRoles(userServiceModel.getRoles());
    }

    @Override
    public void logout() {
        this.currentUser.setUsername(null);
        this.currentUser.setId(null);
        this.currentUser.setRoles(null);
    }




}
