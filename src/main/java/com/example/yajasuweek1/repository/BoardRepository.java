package com.example.yajasuweek1.repository;

import com.example.yajasuweek1.entity.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository  extends JpaRepository<Board,Long> {


}
