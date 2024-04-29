package org.example.SpringBootPathfinderWorkshop.web;

import jakarta.validation.Valid;
import org.example.SpringBootPathfinderWorkshop.model.binding.RouteAddBindingModel;
import org.example.SpringBootPathfinderWorkshop.model.entity.enums.CategoryNameEnum;
import org.example.SpringBootPathfinderWorkshop.model.service.RouteAddServiceModel;
import org.example.SpringBootPathfinderWorkshop.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final ModelMapper modelMapper;

    @Autowired
    public RouteController(RouteService routeService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        model.addAttribute("routesView", this.routeService.selectAll());

        return "routes";
    }

    @GetMapping("/details/{id}")
    public String detailedRoutes(@PathVariable String id, Model model) {

        model.addAttribute("details", this.routeService.selectById(id));

        return "route-details";
    }

    @GetMapping("/add")
    public String add(Model model) {

        if(!model.containsAttribute("routeAddBindingModel")) {
            model.addAttribute("routeAddBindingModel", new RouteAddBindingModel());
        }

        return "add-route";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Principal principal) throws IOException {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        RouteAddServiceModel routeAddServiceModel = this.modelMapper
                .map(routeAddBindingModel, RouteAddServiceModel.class);
        routeAddServiceModel.setGpx(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));

        this.routeService.addNewRoute(routeAddServiceModel, principal);

        return "redirect:/";
    }

    @GetMapping("/car")
    public String carRoutes(Model model) {

        model.addAttribute("carRoutes",
                this.routeService.selectAllByCategory(CategoryNameEnum.CAR));

        return "car";
    }

    @GetMapping("/bicycle")
    public String bicycleRoutes(Model model) {

        model.addAttribute("bicycleRoutes",
                this.routeService.selectAllByCategory(CategoryNameEnum.BICYCLE));

        return "bicycle";
    }

    @GetMapping("/motorcycle")
    public String motorcycleRoutes(Model model) {

        model.addAttribute("motorcycleRoutes",
                this.routeService.selectAllByCategory(CategoryNameEnum.MOTORCYCLE));

        return "motorcycle";
    }

    @GetMapping("/pedestrian")
    public String pedestrianRoutes(Model model) {

        model.addAttribute("pedestrianRoutes",
                this.routeService.selectAllByCategory(CategoryNameEnum.PEDESTRIAN));

        return "pedestrian";
    }
}
