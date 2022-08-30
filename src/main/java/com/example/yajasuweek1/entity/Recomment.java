package com.example.yajasuweek1.entity;

import com.example.yajasuweek1.dto.request.RecommentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter  //private으로 선언한 변수들 사용할 수 있도록 하는 기능
@AllArgsConstructor  //
@NoArgsConstructor   //
public class Recomment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String recomment;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;


    public Recomment(Comment comment, RecommentRequest request) {
        this.comment = comment;
        this.recomment = request.getRecomment();
    }

    public void update(RecommentRequest request) {
        this.recomment = request.getRecomment();
    }
}
