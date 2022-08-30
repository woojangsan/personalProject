package com.example.yajasuweek1.dto.response;

import com.example.yajasuweek1.entity.Board;

public class UpdateResponse {




    private String title;
    private String content;

    public UpdateResponse(Board updatedBoard) {
        this.title = updatedBoard.getTitle();
        this.content = updatedBoard.getContent();
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
