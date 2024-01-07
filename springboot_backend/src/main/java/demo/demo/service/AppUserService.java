package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AppUserService extends UserDetailsService {
    List<AppUser> getAllAppUsers();

    List<AppUser> getAllAppUsersByRole(Role role);

    AppUser getAppUserById(Long id);

    AppUser addNewAppUser(AppUser appUser);

    AppUser updateAppUser(Long userId, AppUser appUser);

    void deleteAppUser(Long id);

    boolean doesUserExist(String email);

    void registerAppUser(String email, String name, String lastName, String password);

}
