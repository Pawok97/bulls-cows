package com.game.bullscows.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "average_quantity_move")
    private double averageQuantityMove;
    @Column(name = "quantity_game")
    private int quantityGame;


    public void check(List<Game> games) {
        double gameCounter = 0.0;
        double gameMovesCounter = 0.0;
        for (Game game : games) {
            if (game.isGameOver()) {
                gameMovesCounter += game.getGameMoves().size();
                gameCounter++;
            }
        }

        this.averageQuantityMove = gameMovesCounter / gameCounter;
        this.quantityGame = (int) gameCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public double getAverageQuantityMove() {

        return averageQuantityMove;
    }

    public void setAverageQuantityMove(double averageQuantityMove) {
        this.averageQuantityMove = averageQuantityMove;
    }

    public int getQuantityGame() {

        return quantityGame;
    }

    public void setQuantityGame(int quantityGame) {
        this.quantityGame = quantityGame;
    }


}
