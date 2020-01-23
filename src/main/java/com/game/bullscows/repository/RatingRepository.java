package com.game.bullscows.repository;

import com.game.bullscows.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {

}
