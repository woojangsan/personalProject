package com.example.yajasuweek1.controller;

import com.example.yajasuweek1.dto.request.BoardRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import com.example.yajasuweek1.dto.response.BoardResponse;
import com.example.yajasuweek1.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;

    }

    @PostMapping("/api/post")
    public String craeteBoard(@RequestBody BoardRequest boardRequest) {
        boardService.createBoard(boardRequest);
        return "등록되었습니다.";

    }

    @GetMapping("/api/post")
    public List<?> getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/api/post/{id}")
    public BoardResponse findBoardById(@PathVariable Long id) {
        return boardService.getBoardById(id);
    }

    @PutMapping("/api/post/{specialId}")  //쿼리 스트링
    public String updateBoard(@PathVariable Long specialId, @RequestBody UpdateRequest updateRequest) {
        boardService.updateBoard(specialId, updateRequest);
        return "수정되었습니다.";
    }

    @DeleteMapping("/api/post/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "삭제되었습니다.";
    }

    @GetMapping("/api/post/post")
    public String test(){
        return "안녕";
    }
}
