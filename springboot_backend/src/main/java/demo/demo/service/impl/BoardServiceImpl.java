package demo.demo.service.impl;

import demo.demo.entity.Board;
import demo.demo.repository.BoardRepo;
import demo.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepo boardRepo;
    @Override
    public List<Board> getAllBoards() {
        return boardRepo.findAll();
    }

    @Override
    public Board addNewBoard(Board board) {
        return boardRepo.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepo.deleteById(id);
    }
}
