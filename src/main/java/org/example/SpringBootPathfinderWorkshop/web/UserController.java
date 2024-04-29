package org.example.SpringBootPathfinderWorkshop.web;

import jakarta.validation.Valid;
import org.example.SpringBootPathfinderWorkshop.model.binding.UserRegisterBindingModel;
import org.example.SpringBootPathfinderWorkshop.model.service.UserServiceModel;
import org.example.SpringBootPathfinderWorkshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-failed")
    public String loginConfirm(@ModelAttribute("username") String username,
                               RedirectAttributes redirectAttributes) {

            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:login";
    }

    @GetMapping("/register")
    public String register(Model model) {

        if(!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());

        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {


        if(bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";
        }

        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        this.userService.saveUser(userServiceModel);

        return "redirect:login";
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {

        model.addAttribute("userProfile", this.userService.selectCurrentUser(username));

        return "profile";
    }
}
