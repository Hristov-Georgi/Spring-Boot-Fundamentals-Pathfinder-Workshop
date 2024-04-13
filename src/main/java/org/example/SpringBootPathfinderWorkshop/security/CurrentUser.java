package org.example.SpringBootPathfinderWorkshop.security;

import org.example.SpringBootPathfinderWorkshop.model.entity.Role;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.RoleNameEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private String id = null;

    private String username = null;

    private Set<Role> roles = new HashSet<>();

    public CurrentUser() {

    }

    public boolean isAdmin() {
        for(Role e : this.roles) {
            if(e.getName() == RoleNameEnum.ADMIN) {
                return true;
            }
        }

        return false;
    }

    public boolean isModerator() {
        for(Role r : this.roles) {
            if(r.getName() == RoleNameEnum.MODERATOR) {
                return true;
            }
        }


        return false;
    }

    public boolean isAnonymous() {

        return this.username == null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
