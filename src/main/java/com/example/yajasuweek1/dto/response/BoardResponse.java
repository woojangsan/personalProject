package com.example.yajasuweek1.dto.response;

import com.example.yajasuweek1.entity.Board;
import com.example.yajasuweek1.entity.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.List;

@Getter
public class BoardResponse {

    private Long id;
    private String title;
    private String author;
    private String content;
    @JsonIgnore
    private String password;

    private List<Comment> comments;

    public BoardResponse(Board savedBoard) {
        this.id = savedBoard.getId();
        this.title = savedBoard.getTitle();
        this.author = savedBoard.getAuthor();
        this.content = savedBoard.getContent();
        this.password = savedBoard.getPassword();
        this.comments = savedBoard.getComments();
    }

}
