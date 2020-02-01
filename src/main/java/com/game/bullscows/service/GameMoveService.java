package com.game.bullscows.service;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.GameMove;
import com.game.bullscows.repository.GameMoveRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Iterable<GameMove> findAll(){
        return gameMoveRepository.findAll();
    }
    public Iterable<GameMove> findByGame(Long gameId){
        return gameMoveRepository.findByGameId(gameId);
    }
    public GameMove findFirstByGameId(Long id){
        return gameMoveRepository.findFirstByGameId(id);
    }
    public List<GameMove> findAllByGameId(Long id){
        return gameMoveRepository.findAllByGameId(id);
    }

}
