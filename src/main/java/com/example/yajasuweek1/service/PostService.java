package com.example.yajasuweek1.service;

import com.example.yajasuweek1.dto.request.PostRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import com.example.yajasuweek1.dto.response.PostResponse;
import com.example.yajasuweek1.entity.Post;
import com.example.yajasuweek1.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    public void createBoard(PostRequest postRequest) {
        postRepository.save(new Post(postRequest));
    }

    public List<?> getBoard() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponseList = new ArrayList<>();
        for (Post post : posts){
            PostResponse postResponse = new PostResponse(post);
            postResponseList.add(postResponse);
        }
        return postResponseList;
    }

    public PostResponse getBoardById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("게시글이 없음")
        );
        PostResponse postResponse = new PostResponse(post);
        return postResponse;
    }


    @Transactional
    public void updateBoard(Long id, UpdateRequest updateRequest) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("게시글이 없음")
        );

        post.edit(updateRequest);  //새로운 데이터 생성이랑 같다  차이점: 게시글 생성 할 때는 아무것도 없는 상태에서 만들어주는거고
        //만들어져 있는 상태에서 새로운 걸 만들어준다.
        postRepository.save(post);
    }


    public void deleteBoard(Long id) {
        postRepository.deleteById(id);
    }

    //컨트롤러에서 반환타입이 있는데 서비스에서는 없는 경우
    //컨트롤러에서 리턴값에 반환타입과 동일한 리턴값을 주게 되면 서비스에서 리턴값이 없어도 됨
}
