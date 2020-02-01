package com.game.bullscows.controller;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.Rating;
import com.game.bullscows.model.User;
import com.game.bullscows.service.GameService;
import com.game.bullscows.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    private GameService gameService;
    private RatingService ratingService;

    @Autowired
    public HomePageController(GameService gameService, RatingService ratingService) {
        this.gameService = gameService;
        this.ratingService = ratingService;
    }

    @GetMapping
    public String welcomePage(@AuthenticationPrincipal User user, Model model) {
        Rating rating = ratingService.findRatingByUserId(user.getId());
        model.addAttribute("rating", rating);
        model.addAttribute("user", user);
        return "home";
    }

    @PostMapping
    public String startNewGame(@AuthenticationPrincipal User user, Model model) {
        Game game = new Game();
        game.setUser(user);

        gameService.addGame(game);

        return "redirect:/game";
    }

}
