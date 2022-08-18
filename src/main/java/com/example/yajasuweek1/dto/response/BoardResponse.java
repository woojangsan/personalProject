package com.example.yajasuweek1.dto.response;

import com.example.yajasuweek1.entity.Board;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class BoardResponse {

    private Long id;
    private String title;
    private String author;
    private String content;
    @JsonIgnore
    private String password;

    public BoardResponse(Board savedBoard) {
        this.id = savedBoard.getId();
        this.title = savedBoard.getTitle();
        this.author = savedBoard.getAuthor();
        this.content = savedBoard.getContent();
        this.password = savedBoard.getPassword();
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }
}
