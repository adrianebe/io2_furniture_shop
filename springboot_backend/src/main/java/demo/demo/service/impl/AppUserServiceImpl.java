package demo.demo.service.impl;

import demo.demo.entity.AppUser;
import demo.demo.entity.enums.Role;
import demo.demo.exception.UserNotFoundException;
import demo.demo.repository.AppUserRepo;
import demo.demo.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepo appUserRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + "was not found!"));
    }

    @Override
    public void registerAppUser(String email, String name, String lastName, String password) {
        AppUser appUser = new AppUser(email,
                name,
                lastName,
                new BCryptPasswordEncoder().encode(password));
        appUser.setRole(Role.USER);
        appUser.setEnabled(true);

        appUserRepo.save(appUser);
    }

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
        appUser.setEnabled(true);
        return appUserRepo.save(appUser);
    }

    public AppUser updateAppUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    public void deleteAppUser(Long id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public boolean doesUserExist(String email) {
        return appUserRepo.existsByEmail(email);
    }

}
