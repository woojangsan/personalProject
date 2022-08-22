package com.example.yajasuweek1.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment{

    @GeneratedValue (strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String comment;

    @JoinColumn(name = "board_id", nullable = false)
    @ManyToOne
    private Board board;
}
