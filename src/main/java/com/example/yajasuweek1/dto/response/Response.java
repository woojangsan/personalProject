package com.example.yajasuweek1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private boolean success;
    private T data;


    public static <T> Response<T> success(T data){
        return new Response<>(true,data);
    }

    public static <T> Response<T> fail(String code, String message) {
        return new Response<>(false,null);
    }
}
