package org.example.SpringBootPathfinderWorkshop.entity;

import jakarta.persistence.*;
import org.example.SpringBootPathfinderWorkshop.entity.enums.LevelEnum;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "full_name")
    private String fullName;

    private int age;

    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @Column(nullable = false)
    private Set<Role> roles;

    @Enumerated(value = EnumType.STRING)
    private LevelEnum level;

    public User() {
    }

    public String getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRole() {
        return roles;
    }

    public void setRole(Set<Role> roles) {
        this.roles = roles;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
