package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.model.entity.Role;
import org.example.SpringBootPathfinderWorkshop.model.entity.UserEntity;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.RoleNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.service.UserServiceModel;
import org.example.SpringBootPathfinderWorkshop.model.view.UserProfileViewModel;
import org.example.SpringBootPathfinderWorkshop.repository.RoleRepository;
import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.example.SpringBootPathfinderWorkshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveUser(UserServiceModel userServiceModel) {

        UserEntity userEntity = this.modelMapper.map(userServiceModel, UserEntity.class);
        userEntity.setPassword(this.passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setLevel(LevelEnum.BEGINNER);

        Role initialRole = this.roleRepository.findByName(RoleNameEnum.USER);
        userEntity.setRoles(Set.of(initialRole));

        this.userRepository.save(userEntity);
    }

    @Override
    public UserProfileViewModel selectCurrentUser(String username) {
        UserEntity user = this.userRepository.findByUsername(username).get();

        return this.modelMapper.map(user, UserProfileViewModel.class);
    }

    @Override
    public UserEntity selectUserEntityByUsername(String username) {
        return this.userRepository.findByUsername(username).get();
    }
}
