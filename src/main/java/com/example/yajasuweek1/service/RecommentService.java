package com.example.yajasuweek1.service;

import com.example.yajasuweek1.dto.request.RecommentRequest;
import com.example.yajasuweek1.dto.response.Response;
import com.example.yajasuweek1.entity.Comment;
import com.example.yajasuweek1.entity.Recomment;
import com.example.yajasuweek1.repository.CommentRepository;
import com.example.yajasuweek1.repository.RecommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommentService {

    private final CommentRepository commentRepository;
    private final RecommentRepository recommentRepository;

    public Response<?> createRecomment(RecommentRequest request) {
        Comment comment = commentRepository.findById(request.getCommentId()).orElseThrow(
                ()-> new NullPointerException("댓글이 없습니다.")
        );
         recommentRepository.save(new Recomment(comment, request));
         return Response.success("대댓글이 작성되었습니다.");
    }

    public Response<?> updateRecomment(Long recommentId, RecommentRequest request) {
        Recomment recomment = recommentRepository.findById(recommentId).orElseThrow();

        recomment.update(request);
        recommentRepository.save(recomment);
        return Response.success("수정되었습니다.");
    }


    public void deleteRecomment(Long recommentId) {
        recommentRepository.deleteById(recommentId);
    }
}
