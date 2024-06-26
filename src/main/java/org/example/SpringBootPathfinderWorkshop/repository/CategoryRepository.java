package org.example.SpringBootPathfinderWorkshop.repository;

import org.example.SpringBootPathfinderWorkshop.model.entity.Category;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByName(CategoryNameEnum categoryNameEnum);
}
