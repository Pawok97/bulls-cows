package com.game.bullscows.controller;

import com.game.bullscows.model.Role;
import com.game.bullscows.model.User;
import com.game.bullscows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) {

        if (user.getPassword()!=null && !user.getPassword().equals(user.getPasswordCheck())){
            model.addAttribute("passwordError","passwords are different");
        }

        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "/registration";
        }
        if (!userService.addUser(user)){
            model.addAttribute("UsernameError", "user exists");
        }
        return "redirect:/login";
    }
}
