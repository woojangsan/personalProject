package com.example.yajasuweek1.service;



import com.example.yajasuweek1.dto.UpdateRequestDto;
import com.example.yajasuweek1.entity.Board;


import com.example.yajasuweek1.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    //게시글 작성
    @Transactional
    public Board createBoard(Board board){
        return boardRepository.save(board);
    }
    //createBoard라는 메소드는 Controller에서 Board타입의 board를 받으므로 매개변수에 Board의 board를 넣어주고
    //return 타입역시 Board이므로 boardRepository의 save라는 메소드에 board를 넣어준다

    //게시글 전체 조회
    public List<Board> getBoard(List<Board> boards) {
        return boardRepository.findAll();
    }

    //게시글 단일 조회
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글 없음")
        );
        return board;
    }


    //게시글 수정
    @Transactional
    public void update(Long id, UpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("게시글이 없습니다.")
        );
        board.update(requestDto);
    }
    //질문!! 컨트롤러에서 반환값을 받는것과 서비스에서 반환값을 받는 것의 차이 : 컨트롤러는 responseBody에서 나타나는 response타입을 반환하는거 같음
    //서비스에서의 반환의 유무는
    //반환값 없이

    //게시글 삭제
    @Transactional
    public void delete(Long id) {
        Board board = new Board();
        boardRepository.deleteById(id);
        board.delete(id);
    }



//
}
