package com.game.bullscows.repository;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.GameMove;
import com.game.bullscows.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameMoveRepository extends CrudRepository<GameMove,Long> {
    Iterable<GameMove> findByGameId(Long gameId);
    GameMove findFirstByGameId(Long id);
    List<GameMove> findAllByGameId(Long id);
}
