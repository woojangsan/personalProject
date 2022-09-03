package com.example.yajasuweek1.entity;

import com.example.yajasuweek1.dto.request.CommentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Post post;


    public Comment(Post post, CommentRequest request) {
        this.comment = request.getComment();
        this.post = post;
    }


    public void update(CommentRequest request) {
        this.comment = request.getComment();
    }
}
