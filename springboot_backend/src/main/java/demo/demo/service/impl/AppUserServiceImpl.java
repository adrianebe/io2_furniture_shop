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
import java.util.Optional;

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

    public void addNewAppUser(AppUser appUser) {
        appUser.setPassword(new BCryptPasswordEncoder().encode(appUser.getPassword()));
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
    }

    public AppUser updateAppUser(Long userId, AppUser appUser) {
        Optional<AppUser> existingUserOptional = appUserRepo.findById(userId);

        if (existingUserOptional.isPresent()) {
            AppUser existingUser = existingUserOptional.get();

            if (appUser.getName() != null) {
                existingUser.setName(appUser.getName());
            }

            if (appUser.getLastName() != null) {
                existingUser.setLastName(appUser.getLastName());
            }

            if (appUser.getEmail() != null) {
                existingUser.setEmail(appUser.getEmail());
            }

            if (appUser.getPassword() != null) {
                existingUser.setPassword(appUser.getPassword());
            }

            if (appUser.getRole() != null) {
                existingUser.setRole(appUser.getRole());
            }

            return appUserRepo.save(existingUser);
        } else {
            throw new UserNotFoundException("User by id: " + userId + "was not found!");
        }
    }

    public void deleteAppUser(Long id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public boolean doesAppUserExist(String email) {
        return appUserRepo.existsByEmail(email);
    }

}
