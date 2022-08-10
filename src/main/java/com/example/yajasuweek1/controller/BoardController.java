package com.example.yajasuweek1.controller;

import com.example.yajasuweek1.dto.UpdateRequestDto;
import com.example.yajasuweek1.entity.Board;
import com.example.yajasuweek1.dto.RequestDto;
import com.example.yajasuweek1.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    //생성자
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/api/post")
    public Board createBoard(@RequestBody RequestDto requestDto) {
       Board board = new Board(requestDto);
        return boardService.createBoard(board);
        //Board타입으로 반환을 받으려면 boardService의 createBoard라는 메소드안에 Board타입의 변수를 넣어주기 위해
        //new 연산자를 이용해서 requestDto를 가진 Board타입의 board를 생성했고 board를 넣었을 때 리턴타입이 Board가 된다.
        //boardService의 createBoard라는 메소드를 생성하여 Repository와 연동해서 DB까지 연동할 수 있도록 한다
    }

    @GetMapping("/api/post")
    public List<Board> getBoard() {
        List<Board> boards = new ArrayList<>();
        return boardService.getBoard(boards);
    }
    //전체 조회이므로 여러개의 반환되는 값은 리스트 타입이어야 하는데 그 리스트 안을 나타내는 타입을 <>안에 넣어준다
    //ArrayList<>로 받는다

    @GetMapping("/api/post/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PutMapping("/api/post/{id}")
    public UpdateRequestDto updateBoard(@PathVariable Long id, @RequestBody UpdateRequestDto requestDto){
       boardService.update(id, requestDto);
       return requestDto;
    }
    //UpdateRequestDto 클래스를 만들어서 title과 content만 반환하는 타입으로 설정해주고 id값과 UpdateRequestDto의 정보를 요청값에 넣는다
    //boardService의 update라는 메소드에 두 값을 넣어주는 로직을 만들고 requestDto는 UpdateRequestDto의 타입을 가지고 있으므로 그 값을 리턴

    @DeleteMapping("/api/post/{id}")
    public String  deleteBoard(@PathVariable Long id){
        boardService.delete(id);
        return id+ " 삭제되었습니다.";
    }
}
