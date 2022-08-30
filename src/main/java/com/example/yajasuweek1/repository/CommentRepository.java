package com.example.yajasuweek1.repository;

import com.example.yajasuweek1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
