package com.game.bullscows.service;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.User;
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

    public Iterable<Game> findByUserId(User user) {
        return gameRepository.findByUser(user);
    }

    public Game findFirstByUserId(Long id) {
        return gameRepository.findFirstByUserId(id);
    }

    public Game findGameById(Long id) {
        return gameRepository.findGameById(id);
    }

    public Game findLastGameByUserId(Long id){
        return gameRepository.findLastGameByUserId(id);
    }

    public List<Game> findAllByUserId(Long id){
        return gameRepository.findAllByUserId(id);    }
}
