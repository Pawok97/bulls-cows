package com.game.bullscows.controller;

import com.game.bullscows.model.Role;
import com.game.bullscows.model.User;
import com.game.bullscows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

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
    public String addUser(User user, Model model) {
        User newUser = userService.findByUsername(user);
        if (newUser!=null){

            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        userService.addUser(user);
        return "redirect:/login";
    }
}
