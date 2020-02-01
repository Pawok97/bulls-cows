package com.game.bullscows.repository;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    Iterable<Game> findByUser(User user);

    Game findFirstByUserId(Long id);
    Game findGameById(Long id);
    @Query(nativeQuery = true, value = "SELECT * FROM game where user_id=? ORDER BY id DESC LIMIT 1")
    Game findLastGameByUserId(Long id);
    List<Game> findAllByUserId(Long id);
}
