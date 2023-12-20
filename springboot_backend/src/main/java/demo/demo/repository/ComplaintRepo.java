package demo.demo.repository;

import demo.demo.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
}
