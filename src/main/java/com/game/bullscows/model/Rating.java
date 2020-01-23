package com.game.bullscows.model;

import javax.persistence.*;

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

}
