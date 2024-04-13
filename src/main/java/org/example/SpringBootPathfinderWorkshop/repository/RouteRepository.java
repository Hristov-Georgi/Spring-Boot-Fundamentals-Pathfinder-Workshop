package org.example.SpringBootPathfinderWorkshop.repository;

import org.example.SpringBootPathfinderWorkshop.model.entity.Route;
import org.example.SpringBootPathfinderWorkshop.service.RouteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {

}
