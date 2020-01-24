package com.game.bullscows.controller;

import com.game.bullscows.model.User;
import com.game.bullscows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomePageController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String welcomePage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "welcomePage";
    }
}
