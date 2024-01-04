package demo.demo.controller;

import demo.demo.entity.Board;
import demo.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("get")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping("add")
    public Board addNewBoard(@RequestBody Board board) {
        return boardService.addNewBoard(board);
    }

    @DeleteMapping("delete/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
    }

}
