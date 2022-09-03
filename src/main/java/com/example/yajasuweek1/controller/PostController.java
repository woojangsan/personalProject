package com.example.yajasuweek1.controller;

import com.example.yajasuweek1.dto.request.PostRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import com.example.yajasuweek1.dto.response.PostResponse;
import com.example.yajasuweek1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;

    }

    @PostMapping("/api/post")
    public String craeteBoard(@RequestBody PostRequest postRequest) {
        postService.createBoard(postRequest);
        return "등록되었습니다.";

    }

    @GetMapping("/api/post")
    public List<?> getBoard() {
        return postService.getBoard();
    }

    @GetMapping("/api/post/{id}")
    public PostResponse findBoardById(@PathVariable Long id) {
        return postService.getBoardById(id);
    }

    @PutMapping("/api/post/{specialId}")  //쿼리 스트링
    public String updateBoard(@PathVariable Long specialId, @RequestBody UpdateRequest updateRequest) {
        postService.updateBoard(specialId, updateRequest);
        return "수정되었습니다.";
    }

    @DeleteMapping("/api/post/{id}")
    public String deleteBoard(@PathVariable Long id) {
        postService.deleteBoard(id);
        return "삭제되었습니다.";
    }

    @GetMapping("/api/post/post")
    public String test(){
        return "안녕";
    }
}
