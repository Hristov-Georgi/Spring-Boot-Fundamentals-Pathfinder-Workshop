package org.example.SpringBootPathfinderWorkshop.config;

import org.example.SpringBootPathfinderWorkshop.repository.UserRepository;
import org.example.SpringBootPathfinderWorkshop.service.impl.PathfinderUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(httpRequest -> httpRequest
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/", "/about").permitAll()
                        .requestMatchers("/users/login", "/users/login-failed", "/users/register").permitAll()
//                        .requestMatchers("").hasRole(RoleNameEnum.ADMIN.name())
                        .anyRequest().authenticated()
                ).formLogin(login -> login
                        .loginPage("/users/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true) //set to true, because first login awlayes failed
                        .failureForwardUrl("/users/login-failed")
                ).logout(logout -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/").permitAll()
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                ).build();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new PathfinderUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
