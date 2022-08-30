package com.example.yajasuweek1.controller;

import com.example.yajasuweek1.dto.request.RecommentRequest;
import com.example.yajasuweek1.dto.response.Response;
import com.example.yajasuweek1.service.RecommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RecommentController {

    private final RecommentService recommentService;

    @PostMapping("/api/recomment")
    public Response<?> createRecomment(@RequestBody RecommentRequest request){
        return recommentService.createRecomment(request);

    }

    @PutMapping("/api/recomment/{recommentId}")
    public Response<?> updateRecomment(@PathVariable Long recommentId, @RequestBody RecommentRequest request){
        return recommentService.updateRecomment(recommentId, request);
    }

    @DeleteMapping("/api/recomment/{recommentId}")
    public String deleteRecomment(@PathVariable Long recommentId){
        recommentService.deleteRecomment(recommentId);
        return "삭제되었습니다.";
    }
}
