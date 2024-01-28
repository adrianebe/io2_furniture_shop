package demo.demo.repository;

import demo.demo.entity.Assortment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssortmentRepo extends JpaRepository<Assortment, Long> {

    List<Assortment> findAllByRoomType(String roomType);

    Assortment findOneByIdAndRoomType(Long id, String roomType);
}
