package com.example.yajasuweek1.entity;

import com.example.yajasuweek1.dto.request.PostRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Post {

    @GeneratedValue (strategy = GenerationType.IDENTITY) //1개씩 추가되는거
    @Id
    private Long id;

    @Column(length = 100)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String content;
    private String password;


    public Post(PostRequest postRequest) {
        this.title = postRequest.getTitle();
        this.author = postRequest.getAuthor();
        this.content = postRequest.getContent();
        this.password = postRequest.getPassword();
    }

    public Post() {

    }
    //생성자를 만들어준 이유는 Service 로직에서 new연산자로 객체를 생성했기 때문인데 boardRequest의 정보들을 받는다고 되어있을 때
    //boardRequest의 멤버변수들이 private으로 선언되어 있으므로 가져오고 싶은 정보를 읽어주어야 한다 그래서 boardRequest.Get~이 필요하다
    //BoardResponse에서도 마찬가지다


    public void edit(UpdateRequest updateRequest) {
        this.title = updateRequest.getTitle();
        this.content = updateRequest.getContent();
    }
}
