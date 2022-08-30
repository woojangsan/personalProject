package com.example.yajasuweek1.entity;

import com.example.yajasuweek1.dto.request.CommentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Comment{

    @GeneratedValue (strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String comment;

    @JsonIgnore
    @JoinColumn(name = "board_id", nullable = false)
    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"comment"})
    @OrderBy("id desc")
    private List<Recomment> recomments;


    public Comment(Board board, CommentRequest request) {
        this.comment = request.getComment();
        this.board = board;
    }


    public void update(CommentRequest request) {
        this.comment = request.getComment();
    }
}
