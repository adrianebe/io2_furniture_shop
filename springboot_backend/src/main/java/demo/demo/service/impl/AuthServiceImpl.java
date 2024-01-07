package demo.demo.service.impl;

import demo.demo.config.jwt.JwtTokenProvider;
import demo.demo.entity.AppUser;
import demo.demo.service.AppUserService;
import demo.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AppUserService appUserService;
    private final JwtTokenProvider jwtTokenProvider;

    public boolean registerUser(String name, String lastName, String email, String password) {
        if (appUserService.doesAppUserExist(email)) {
            return false;
        }

        appUserService.registerAppUser(name, lastName, email, password);
        return true;
    }

    public boolean validateCredentials(String email, String password) {
        try {
            AppUser user = (AppUser) appUserService.loadUserByUsername(email);
            if (new BCryptPasswordEncoder().matches(password, user.getPassword()))
                return true;
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("No user with such username");
        }

        return false;
    }

    public String getJwtToken(String email) {
        AppUser user = (AppUser) appUserService.loadUserByUsername(email);
        String userRole = user.getRole().name();
        return jwtTokenProvider.getAccessToken(user.getEmail(), userRole);
    }
}
