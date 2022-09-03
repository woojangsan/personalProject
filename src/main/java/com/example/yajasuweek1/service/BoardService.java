package com.example.yajasuweek1.service;

import com.example.yajasuweek1.dto.request.BoardRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import com.example.yajasuweek1.dto.response.BoardResponse;
import com.example.yajasuweek1.dto.response.UpdateResponse;
import com.example.yajasuweek1.entity.Board;
import com.example.yajasuweek1.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }


    public void createBoard(BoardRequest boardRequest) {
        boardRepository.save(new Board(boardRequest));
    }

    public List<?> getBoard() {
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> boardResponseList = new ArrayList<>();
        for (Board board : boards){
            BoardResponse boardResponse = new BoardResponse(board);
            boardResponseList.add(boardResponse);
        }
        return boardResponseList;
    }

    public BoardResponse getBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("게시글이 없음")
        );
        BoardResponse boardResponse = new BoardResponse(board);
        return boardResponse;
    }


    @Transactional
    public void updateBoard(Long id, UpdateRequest updateRequest) {
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("게시글이 없음")
        );

        board.edit(updateRequest);  //새로운 데이터 생성이랑 같다  차이점: 게시글 생성 할 때는 아무것도 없는 상태에서 만들어주는거고
        //만들어져 있는 상태에서 새로운 걸 만들어준다.
        boardRepository.save(board);
    }


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    //컨트롤러에서 반환타입이 있는데 서비스에서는 없는 경우
    //컨트롤러에서 리턴값에 반환타입과 동일한 리턴값을 주게 되면 서비스에서 리턴값이 없어도 됨
}
