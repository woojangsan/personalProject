package com.example.yajasuweek1.dto.request;

import lombok.Getter;

@Getter
public class BoardRequest {

    private Long id;
    private String title;
    private String author;
    private String content;
    private String password;



    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public  String getContent(){
        return content;
    }
    public  String getPassword(){
        return password;
    }
}
