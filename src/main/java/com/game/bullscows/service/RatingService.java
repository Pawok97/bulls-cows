package com.game.bullscows.service;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.Rating;
import com.game.bullscows.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }


    public Rating findFirstById(Long id) {

        return ratingRepository.findFirstById(id);
    }
    public Iterable<Rating> findAllRating(){
        return ratingRepository.findAll();
    }

    public void updateRating(Rating rating, List<Game> gameList) {
        rating.check(gameList);
        ratingRepository.save(rating);
    }
    public Rating findRatingByUserId(Long id){
        return ratingRepository.findFirstByUserId(id);
    }
    public List<Rating> sortedRating(){
        return ratingRepository.sortedRating();
    }

}
