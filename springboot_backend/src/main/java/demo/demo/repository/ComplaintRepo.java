package demo.demo.repository;

import demo.demo.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
    List<Complaint> findAllByAppUserId(Long appUserId);

    void deleteByIdAndAppUserId(Long id, Long appUserId);
}
