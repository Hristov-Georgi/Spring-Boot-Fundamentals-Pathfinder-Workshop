package org.example.SpringBootPathfinderWorkshop.service.impl;

import org.example.SpringBootPathfinderWorkshop.model.view.RouteViewModel;
import org.example.SpringBootPathfinderWorkshop.repository.RouteRepository;
import org.example.SpringBootPathfinderWorkshop.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
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
}
