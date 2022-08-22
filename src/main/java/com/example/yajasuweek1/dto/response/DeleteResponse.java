package com.example.yajasuweek1.dto.response;

import com.example.yajasuweek1.entity.Board;

public class DeleteResponse {
    private String msg = "삭제되었습니다.";

    public DeleteResponse(Board board) {
    }

    public String getMsg() {
        return msg;
    }
}
