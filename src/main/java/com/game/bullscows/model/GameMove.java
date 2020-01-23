package com.game.bullscows.model;

import javax.persistence.*;

@Entity
@Table(name = "game_move")
public class GameMove {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private String bulls;
    private String cows;

    public GameMove() {
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
