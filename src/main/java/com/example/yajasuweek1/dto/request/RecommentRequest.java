package com.example.yajasuweek1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecommentRequest {

    private Long commentId;

    private String recomment;
}
