package com.game.bullscows.service;

import com.game.bullscows.model.Rating;
import com.game.bullscows.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addRating(Rating rating){
        ratingRepository.save(rating);
    }
    public void editRating(Rating rating){
        ratingRepository.save(rating);
    }
}
