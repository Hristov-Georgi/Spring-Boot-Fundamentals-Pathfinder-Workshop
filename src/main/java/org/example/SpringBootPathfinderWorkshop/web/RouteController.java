package org.example.SpringBootPathfinderWorkshop.web;

import org.example.SpringBootPathfinderWorkshop.security.CurrentUser;
import org.example.SpringBootPathfinderWorkshop.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final CurrentUser currentUser;
    private final RouteService routeService;

    @Autowired
    public RouteController(CurrentUser currentUser, RouteService routeService) {
        this.currentUser = currentUser;
        this.routeService = routeService;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        if(this.currentUser.isAnonymous()) {
            return "redirect:/users/login";
        }

        model.addAttribute("routesView", this.routeService.selectAll());


        return "routes";
    }
}
