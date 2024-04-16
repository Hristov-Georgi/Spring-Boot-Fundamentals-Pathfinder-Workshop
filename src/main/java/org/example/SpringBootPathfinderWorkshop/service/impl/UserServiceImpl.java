package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.model.entity.Role;
import org.example.SpringBootPathfinderWorkshop.model.entity.User;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.RoleNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.service.UserServiceModel;
import org.example.SpringBootPathfinderWorkshop.repository.RoleRepository;
import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.example.SpringBootPathfinderWorkshop.security.CurrentUser;
import org.example.SpringBootPathfinderWorkshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
        this.currentUser.setId(userServiceModel.getId());
        this.currentUser.setUsername(userServiceModel.getUsername());
        this.currentUser.setRoles(userServiceModel.getRoles());
    }

    @Override
    public void logout() {
        this.currentUser.setId(null);
        this.currentUser.setUsername(null);
        this.currentUser.setRoles(null);
    }

    @Override
    public boolean isUsernameExists(String username) {

        return this.userRepository.findByUsername(username).isPresent();

    }

    @Override
    public void saveUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setLevel(LevelEnum.BEGINNER);

        Role initialRole = this.roleRepository.findByName(RoleNameEnum.USER);
        user.setRoles(Set.of(initialRole));

        this.userRepository.save(user);
    }

    @Override
    public UserServiceModel selectByUserId(String id) {

        User user = this.userRepository.findById(id).get();

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public User selectCurrentUser(String id) {
        return this.userRepository.findById(id).get();
    }
}
