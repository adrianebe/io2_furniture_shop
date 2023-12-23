package demo.demo.repository;

import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    List<AppUser> findAllByRole(Role role);
}
