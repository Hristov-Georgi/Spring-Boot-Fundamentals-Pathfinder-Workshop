package org.example.SpringBootPathfinderWorkshop.service.impl;


import org.example.SpringBootPathfinderWorkshop.model.entity.Role;
import org.example.SpringBootPathfinderWorkshop.model.entity.UserEntity;
import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.stream.Collectors;

public class PathfinderUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PathfinderUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByUsername(username)
                .map(this::mapUserDetails)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with username " + username + " does not exists."));
    }

    private UserDetails mapUserDetails(UserEntity userEntity) {

        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity
                        .getRoles()
                        .stream()
                        .map(this::mapGrantedAuthority)
                        .collect(Collectors.toList()))
                .build();

    }

    private GrantedAuthority mapGrantedAuthority(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getName().name());
    }

}
