package com.example.yajasuweek1.controller;

import com.example.yajasuweek1.dto.request.BoardRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import com.example.yajasuweek1.dto.response.BoardResponse;
import com.example.yajasuweek1.dto.response.DeleteResponse;
import com.example.yajasuweek1.dto.response.UpdateResponse;
import com.example.yajasuweek1.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;

    }

    @PostMapping("/api/post")
    public BoardResponse craeteBoard(@RequestBody BoardRequest boardRequest){
        return boardService.createBoard(boardRequest);
    }

    @GetMapping("/api/post")
    public List<BoardResponse> getBoard(){
        return boardService.getBoard();
    }

    @GetMapping("/api/post/{id}")
    public BoardResponse findBoardById(@PathVariable Long id){
        return boardService.findBoardById(id);
    }

    @PutMapping("/api/post/{id}")
    public UpdateResponse updateBoard(@PathVariable Long id, @RequestBody UpdateRequest updateRequest){
        return boardService.updateBoard(id, updateRequest);
    }

    @DeleteMapping("/api/post/{id}")
    public String  deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "삭제되었습니다.";
    }
}
