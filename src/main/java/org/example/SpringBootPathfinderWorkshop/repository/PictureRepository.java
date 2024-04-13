package org.example.SpringBootPathfinderWorkshop.repository;

import org.example.SpringBootPathfinderWorkshop.model.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {

    @Query("SELECT p.url FROM Picture p")
    List<String> findAllUrls();
}
