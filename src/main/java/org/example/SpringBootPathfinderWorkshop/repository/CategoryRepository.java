package org.example.SpringBootPathfinderWorkshop.repository;

import org.example.SpringBootPathfinderWorkshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}