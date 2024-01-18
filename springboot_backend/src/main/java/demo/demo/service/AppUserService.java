package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AppUserService extends UserDetailsService {
    AppUser getCurrentUser();

    List<AppUser> getAllAppUsers();

    List<AppUser> getAllAppUsersByRole(Role role);

    AppUser getAppUserById(Long id);

    void addNewAppUser(AppUser appUser);

    AppUser updateAppUser(Long userId, AppUser appUser);

    void deleteAppUser(Long id);

    void registerAppUser(String name, String lastName, String email, String password);

    List<AppUser> getAllActiveOrNotActiveAppUsers(boolean enabled);
}
