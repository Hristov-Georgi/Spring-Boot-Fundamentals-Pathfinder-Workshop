package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.model.entity.Category;
import org.example.SpringBootPathfinderWorkshop.model.entity.Picture;
import org.example.SpringBootPathfinderWorkshop.model.entity.Route;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.service.RouteAddServiceModel;
import org.example.SpringBootPathfinderWorkshop.model.view.RouteDetailedView;
import org.example.SpringBootPathfinderWorkshop.model.view.RouteViewModel;
import org.example.SpringBootPathfinderWorkshop.model.view.RoutesByCategoryViewModel;
import org.example.SpringBootPathfinderWorkshop.repository.RouteRepository;
import org.example.SpringBootPathfinderWorkshop.security.CurrentUser;
import org.example.SpringBootPathfinderWorkshop.service.CategoryService;
import org.example.SpringBootPathfinderWorkshop.service.RouteService;
import org.example.SpringBootPathfinderWorkshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryService categoryService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> selectAll() {

        List<RouteViewModel> routes = this.routeRepository.findAll()
                .stream()
                .map(route -> {
                    RouteViewModel routeViewModel = this.modelMapper.map(route, RouteViewModel.class);

                    if(route.getPictures().isEmpty()) {
                        routeViewModel.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                    }
                    return routeViewModel;})
                .collect(Collectors.toList());

        return routes;
    }

    @Override
    public RouteDetailedView selectById(String routeId) {

        Route route = this.routeRepository.findById(routeId).get();

        return this.modelMapper.map(route, RouteDetailedView.class);

    }


    @Override
    public void addNewRoute(RouteAddServiceModel routeAddServiceModel) {

        Route route = this.modelMapper.map(routeAddServiceModel, Route.class);

        route.setAuthor(this.userService.selectCurrentUser(this.currentUser.getId()));

        route.setCategories(routeAddServiceModel.getCategories()
                .stream()
                .map(this.categoryService::selectByName)
                .collect(Collectors.toList()));

        this.routeRepository.save(route);
    }

    @Override
    public List<RoutesByCategoryViewModel> selectAllByCategory(CategoryNameEnum categoryName) {

        List<Route> routesByCategory = this.routeRepository.findAllByCategory(categoryName);

        return routesByCategory.stream()
                .map(r -> {
                    RoutesByCategoryViewModel route = this.modelMapper.map(r, RoutesByCategoryViewModel.class);

                    if(r.getPictures().isEmpty()) {
                        route.setPictureUrl("/images/pic1.jpg");
                    } else {
                        route.setPictureUrl(r.getPictures().stream().findFirst().get().getUrl());
                    }
                    return route;

                })
                .toList();

    }
}
