package com.example.yajasuweek1.dto.response;

import com.example.yajasuweek1.entity.Post;

public class UpdateResponse {




    private String title;
    private String content;

    public UpdateResponse(Post updatedPost) {
        this.title = updatedPost.getTitle();
        this.content = updatedPost.getContent();
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
