package com.example.yajasuweek1.service;

import com.example.yajasuweek1.dto.request.BoardRequest;
import com.example.yajasuweek1.dto.request.UpdateRequest;
import com.example.yajasuweek1.dto.response.BoardResponse;
import com.example.yajasuweek1.dto.response.DeleteResponse;
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


    public BoardResponse createBoard(BoardRequest boardRequest) {
        Board board = new Board(boardRequest); //1.데이터를 만들었음
        Board savedBoard = boardRepository.save(board); //2.DB에 저장해야함 //오른쪽에 있는건 Board타입으로 만든 게시글 board를 저장한거
        BoardResponse boardResponse = new BoardResponse(savedBoard);
        return boardResponse;
    }
    // 1.게시글을 작성해라 2.게시글을 저장-DB에 저장 3.


    public List<BoardResponse> getBoard() {
        List<Board> boards = boardRepository.findAll();
        List<BoardResponse> boardResponseList = new ArrayList<>();
        for (Board board : boards){
            BoardResponse boardResponse = new BoardResponse(board);
            boardResponseList.add(boardResponse);
        }
        return boardResponseList;
    }

    public BoardResponse findBoardById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("게시글이 없음")
        );
        BoardResponse boardResponse = new BoardResponse(board);
        return boardResponse;
    }


    @Transactional
    public UpdateResponse updateBoard(Long id, UpdateRequest updateRequest) {
        Board board = boardRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("게시글이 없음")
        );

        board.update(updateRequest);
        Board updatedBoard = boardRepository.save(board);
        UpdateResponse updateResponse = new UpdateResponse(updatedBoard);
        return updateResponse;
    }


    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    //컨트롤러에서 반환타입이 있는데 서비스에서는 없는 경우
    //컨트롤러에서 리턴값에 반환타입과 동일한 리턴값을 주게 되면 서비스에서 리턴값이 없어도 됨
}
