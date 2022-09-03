package com.example.yajasuweek1.service;

import com.example.yajasuweek1.dto.request.CommentRequest;
import com.example.yajasuweek1.dto.response.Response;
import com.example.yajasuweek1.entity.Post;
import com.example.yajasuweek1.entity.Comment;
import com.example.yajasuweek1.repository.PostRepository;
import com.example.yajasuweek1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    public Response<?> createComment(CommentRequest request) {
        Post post = postRepository.findById(request.getBoardId()).orElseThrow(
                () -> new NullPointerException("게시글이 존재하지 않습니다.")
        );

        commentRepository.save(new Comment(post, request));

        return Response.success("success");
    }


    public Response<?> editComment(Long commentId, CommentRequest request) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new NullPointerException("댓글이 존재하지 않습니다.")
        );
        comment.update(request);
        commentRepository.save(comment);
        return Response.success("success");
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);

    }
}
