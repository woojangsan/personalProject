package com.example.yajasuweek1.controller;

import com.example.yajasuweek1.dto.request.CommentRequest;
import com.example.yajasuweek1.dto.response.Response;
import com.example.yajasuweek1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comment")
    public Response<?> createComment(@RequestBody CommentRequest request){
        return commentService.createComment(request);
    }

    @PutMapping("/api/comment/{commentId}")
    public Response<?> editComment(@PathVariable Long commentId,@RequestBody CommentRequest request){
        return commentService.editComment(commentId, request);
    }

    @DeleteMapping("/api/comment/{commentId}")
    public Response<?> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return Response.success("success");
    }



}
