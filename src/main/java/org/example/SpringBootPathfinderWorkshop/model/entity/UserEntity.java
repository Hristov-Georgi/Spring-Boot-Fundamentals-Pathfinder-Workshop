package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

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

    @ManyToMany(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private Set<Role> roles;

    @Enumerated(value = EnumType.STRING)
    private LevelEnum level;

    public UserEntity() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
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
