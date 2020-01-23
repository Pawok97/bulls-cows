package com.game.bullscows.service;

import com.game.bullscows.model.Game;
import com.game.bullscows.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public void setGameRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public Iterable<Game> listGames() {
        return gameRepository.findAll();
    }
}
