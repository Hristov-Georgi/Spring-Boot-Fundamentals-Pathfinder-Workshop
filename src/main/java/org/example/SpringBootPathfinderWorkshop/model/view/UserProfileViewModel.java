package org.example.SpringBootPathfinderWorkshop.model.view;

import org.example.SpringBootPathfinderWorkshop.model.entity.enums.LevelEnum;

public class UserProfileViewModel {

    private String id;

    private LevelEnum level;

    private String fullName;

    private String username;

    private int age;

    public UserProfileViewModel() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
