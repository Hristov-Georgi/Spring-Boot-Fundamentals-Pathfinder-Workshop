package org.example.SpringBootPathfinderWorkshop.web;

import jakarta.validation.Valid;
import org.example.SpringBootPathfinderWorkshop.model.binding.UserLoginBindingModel;
import org.example.SpringBootPathfinderWorkshop.model.binding.UserRegisterBindingModel;
import org.example.SpringBootPathfinderWorkshop.model.service.UserServiceModel;
import org.example.SpringBootPathfinderWorkshop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String login(Model model) {

        if(!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                        bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = this.userService.validateUser(userLoginBindingModel.getUsername(),
                userLoginBindingModel.getPassword());

        if(userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

        this.userService.login(userServiceModel);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {

        if(!model.containsAttribute("userRegisterBindingModel")) {

            model
                    .addAttribute("userRegisterBindingModel", new UserRegisterBindingModel())
                    .addAttribute("notEqualPasswords", false)
                    .addAttribute("isUsernameOccupied", false);

        }

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        boolean arePasswordsEqual = userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword());

        boolean isUsernameOccupied = this.userService.isUsernameExists(userRegisterBindingModel.getUsername());

        if(bindingResult.hasErrors() || !arePasswordsEqual || isUsernameOccupied) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);
            redirectAttributes.addFlashAttribute("notEqualPasswords", true);
            redirectAttributes.addFlashAttribute("isUsernameOccupied", isUsernameOccupied); //true

            return "redirect:register";
        }



        UserServiceModel userServiceModel = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        this.userService.saveUser(userServiceModel);

        return "redirect:login";
    }
}
