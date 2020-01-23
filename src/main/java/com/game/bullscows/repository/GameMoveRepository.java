package com.game.bullscows.repository;

import com.game.bullscows.model.GameMove;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameMoveRepository extends CrudRepository<GameMove,Long> {
}
