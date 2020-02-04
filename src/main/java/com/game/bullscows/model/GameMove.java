package com.game.bullscows.model;

import com.game.bullscows.validator.GameMoveNumberConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "game_move")
public class GameMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @GameMoveNumberConstraint
    private String number;
    private String bulls;
    private String cows;
    @ManyToOne
    private Game game;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameMove() {
    }

    public GameMove(String number) {
        this.number = number;

    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBulls() {
        return bulls;
    }

    public void setBulls(String bulls) {
        this.bulls = bulls;
    }

    public String getCows() {
        return cows;
    }

    public void setCows(String cows) {
        this.cows = cows;
    }


}
