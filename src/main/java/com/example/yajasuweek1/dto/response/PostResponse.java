package com.example.yajasuweek1.dto.response;

import com.example.yajasuweek1.entity.Post;
import com.example.yajasuweek1.entity.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponse {

    private Long id;
    private String title;
    private String author;
    private String content;
    @JsonIgnore
    private String password;

    private List<Comment> comments;

    public PostResponse(Post savedPost) {
        this.id = savedPost.getId();
        this.title = savedPost.getTitle();
        this.author = savedPost.getAuthor();
        this.content = savedPost.getContent();
        this.password = savedPost.getPassword();
    }

}
