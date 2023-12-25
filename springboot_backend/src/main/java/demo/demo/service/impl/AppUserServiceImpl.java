package demo.demo.service.impl;

import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;
import demo.demo.exception.UserNotFoundException;
import demo.demo.repository.AppUserRepo;
import demo.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepo appUserRepo;

    public List<AppUser> getAllAppUsers() {
        return appUserRepo.findAll();
    }

    public List<AppUser> getAllAppUsersByRole(Role role) {
        return appUserRepo.findAllByRole(role);
    }


    public AppUser getAppUserById(Long id) {
        return appUserRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id: " + id + "was not found!"));
    }

    public AppUser addNewAppUser(AppUser appUser) {
        appUser.setRole(Role.USER);
        appUser.setStatus(1);
        return appUserRepo.save(appUser);
    }

    public AppUser updateAppUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    public void deleteAppUser(Long id) {
        appUserRepo.deleteById(id);
    }
}
