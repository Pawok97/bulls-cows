package com.game.bullscows.controller;

import com.game.bullscows.model.Game;
import com.game.bullscows.model.GameMove;
import com.game.bullscows.model.Rating;
import com.game.bullscows.model.User;
import com.game.bullscows.service.GameMoveService;
import com.game.bullscows.service.GameService;
import com.game.bullscows.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/game")
public class GameController {

    private GameService gameService;
    private GameMoveService gameMoveService;
    private RatingService ratingService;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @Autowired
    public void setGameMoveService(GameMoveService gameMoveService) {
        this.gameMoveService = gameMoveService;
    }

    @PostMapping
    public String addMove(@AuthenticationPrincipal User user ,@Valid GameMove number, BindingResult bindingResult, Model model, @RequestParam Long gameId) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);
            Game game = gameService.findLastGameByUserId(user.getId());
            Iterable<GameMove> moves = gameMoveService.findByGame(game.getId());
            model.addAttribute("game", game);
            model.addAttribute("moves", moves);
            model.mergeAttributes(errorsMap);
            return "/game";
        }
        GameMove move = new GameMove(number.getNumber());
        Game game = gameService.findGameById(gameId);
        game.addMove(move);
        gameMoveService.addGameMove(move);
        if (game.isGameOver()) {
            gameService.addGame(game);
            List<Game> gameList = gameService.findAllByUserId(game.getUser().getId());
            Rating rating = ratingService.findRatingByUserId(game.getUser().getId());
            ratingService.updateRating(rating, gameList);
            return "gameover";
        }
        gameService.addGame(game);
        return "redirect:/game";
    }

    @GetMapping
    public String game(@AuthenticationPrincipal User user, Model model) {
        Game game = gameService.findLastGameByUserId(user.getId());
        if (game.isGameOver()) {

            Game newGame = new Game();

            game.setUser(user);
            gameService.addGame(game);

            return "game";
        }
        Iterable<GameMove> moves = gameMoveService.findByGame(game.getId());
        model.addAttribute("game", game);
        model.addAttribute("moves", moves);
        return "game";
    }
}
