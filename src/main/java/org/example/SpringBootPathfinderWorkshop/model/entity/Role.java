package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.RoleNameEnum;
import org.hibernate.annotations.UuidGenerator;


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
