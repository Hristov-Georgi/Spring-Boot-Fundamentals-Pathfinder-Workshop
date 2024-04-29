package org.example.SpringBootPathfinderWorkshop.service;

import org.example.SpringBootPathfinderWorkshop.model.entity.Category;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.service.RouteAddServiceModel;
import org.example.SpringBootPathfinderWorkshop.model.view.RouteDetailedView;
import org.example.SpringBootPathfinderWorkshop.model.view.RouteViewModel;
import org.example.SpringBootPathfinderWorkshop.model.view.RoutesByCategoryViewModel;

import java.security.Principal;
import java.util.List;

public interface RouteService {

    List<RouteViewModel> selectAll();

    RouteDetailedView selectById(String routeId);

    void addNewRoute(RouteAddServiceModel routeAddServiceModel, Principal principal);

    List<RoutesByCategoryViewModel> selectAllByCategory(CategoryNameEnum categoryName);

}
