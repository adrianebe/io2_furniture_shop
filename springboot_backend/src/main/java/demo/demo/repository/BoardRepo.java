package demo.demo.repository;

import demo.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepo extends JpaRepository<Board, Long> {
}
