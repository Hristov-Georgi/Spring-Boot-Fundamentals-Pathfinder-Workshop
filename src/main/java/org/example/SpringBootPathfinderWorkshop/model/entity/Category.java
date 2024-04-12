package org.example.SpringBootPathfinderWorkshop.model.entity;

import jakarta.persistence.*;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Table(name = "categories")
public class Category {

    @Id
    @UuidGenerator
    private String id;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Enumerated(value = EnumType.STRING)
    private CategoryNameEnum name;


    public Category() {
    }

    public String getId() {
        return id;
    }

    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
