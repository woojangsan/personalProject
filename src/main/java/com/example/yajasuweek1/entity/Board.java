package com.example.yajasuweek1.entity;

import com.example.yajasuweek1.dto.RequestDto;
import com.example.yajasuweek1.dto.UpdateRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Board{

    //변수(제목, 작성자명, 내용) private 권장

    //ID가 자동으로 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private String author;
    private String content;
    @JsonIgnore
    private String password;

       //생성자가 반드시 필요함 => Board board = new Board(request);를 사용하기 위해서는 생성자를 만들어 주어야함
    public Board(RequestDto requestDto){
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
    }


    //인스턴스가 생성 될 때 기본 생성자가 컴파일시 자동 생성되고 1개일 시에는 생략이 가능하지만
    //매개변수가 있는 생성자를 생성하게 되어 생성자가 2개 이상일 때는 기본 생성자를 따로 적어주어야 한다
    public Board() {

    }


    //private으로 선언된 변수들을 다른 클래스에서 접근하기 위해서
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }

    public Long getId(){
        return id;
    }


    public void update(UpdateRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
    }

    public void delete(Long id) {
        this.id = id;
    }
}

