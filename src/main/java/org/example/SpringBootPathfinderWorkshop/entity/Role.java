package org.example.SpringBootPathfinderWorkshop.entity;

import jakarta.persistence.*;
import org.example.SpringBootPathfinderWorkshop.entity.enums.RoleNameEnum;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, name = "role")
    @Enumerated(value = EnumType.STRING)
    private RoleNameEnum name;

    public Role() {
    }

    public String getId() {
        return id;
    }

    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }
}
