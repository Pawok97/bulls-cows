package com.game.bullscows.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private String number;

    private boolean gameOver;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private List<GameMove> gameMoves;

    public Game() {
        startGame();
    }

    private String randomNumber() {
        Random random = new Random();
        int rnd;
        String result;
        for (; ; ) {
            rnd = random.nextInt((9900) + 100);
            String format = String.format("%4d", rnd);
            if (format.matches("(?!.*(.).*\\1)\\d{4}")) {
                result = format;
                break;
            }
        }
        return result;
    }
    public void startGame() {
        this.number=randomNumber();
        this.gameOver=false;
        gameMoves=new ArrayList<>();
    }


    public void addMove(GameMove move){
        checkNumber(move);
        if (Integer.parseInt(move.getBulls())==4){
            this.gameOver=true;
        }
        gameMoves.add(move);
    }
    public void checkNumber(GameMove guessNumber) {
        int bulls = 0;
        int cows = 0;
        if (guessNumber.getNumber().length() == 4 && guessNumber.getNumber().matches("(?!.*(.).*\\1)\\d{4}")) {
            for (int i = 0; i < guessNumber.getNumber().length(); i++) {
                if (guessNumber.getNumber().charAt(i) == this.number.charAt(i)) {
                    bulls++;
                } else if (this.number.indexOf(guessNumber.getNumber().charAt(i))!=-1) {
                    cows++;
                }
            }
        }

        guessNumber.setBulls(String.valueOf(bulls));
        guessNumber.setCows(String.valueOf(cows));

    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public List<GameMove> getGameMoves() {
        return gameMoves;
    }

    public void setGameMoves(List<GameMove> gameMoves) {
        this.gameMoves = gameMoves;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
