package org.example.SpringBootPathfinderWorkshop.service;

import org.example.SpringBootPathfinderWorkshop.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {

    List<RouteViewModel> selectAll();
}
