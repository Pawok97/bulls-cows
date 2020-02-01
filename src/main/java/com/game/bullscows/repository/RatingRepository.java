package com.game.bullscows.repository;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {
    Rating findFirstByUserId(Long id);
    Rating findFirstById(Long id);
    @Query(nativeQuery = true, value = "select * from rating order by average_quantity_move")
    List<Rating> sortedRating();

}
