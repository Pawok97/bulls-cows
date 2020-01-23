package com.game.bullscows.service;

import com.game.bullscows.model.GameMove;
import com.game.bullscows.repository.GameMoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameMoveService {

    private GameMoveRepository gameMoveRepository;

    @Autowired
    public void setGameMoveService(GameMoveRepository gameMoveRepository) {
        this.gameMoveRepository = gameMoveRepository;
    }
    public void addGameMove(GameMove gameMove){
        gameMoveRepository.save(gameMove);
    }
}
