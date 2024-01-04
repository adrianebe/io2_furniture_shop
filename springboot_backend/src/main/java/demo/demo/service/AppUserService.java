package demo.demo.service;

import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAllAppUsers();

    List<AppUser> getAllAppUsersByRole(Role role);

    AppUser getAppUserById(Long id);

    AppUser addNewAppUser(AppUser appUser);

    AppUser updateAppUser(AppUser appUser);

    void deleteAppUser(Long id);
}
