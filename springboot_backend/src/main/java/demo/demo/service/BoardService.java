package demo.demo.service;

import demo.demo.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> getAllBoards();

    Board addNewBoard(Board board);

    void deleteBoard(Long id);
}
