package com.game.bullscows.controller;

import com.game.bullscows.model.Rating;
import com.game.bullscows.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rating")
public class RatingPageController {
    private RatingService ratingService;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public String rating(Model model) {
        List<Rating> rating = ratingService.sortedRating();
        model.addAttribute("ratings", rating);
        return "rating";
    }
}
