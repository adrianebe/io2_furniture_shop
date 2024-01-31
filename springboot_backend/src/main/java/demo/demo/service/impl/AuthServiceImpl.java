package demo.demo.service.impl;

import demo.demo.config.jwt.JwtTokenProvider;
import demo.demo.entity.AppUser;
import demo.demo.exception.custom.InvalidCredentialsException;
import demo.demo.exception.custom.UserNotFoundException;
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

    @Override
    public void registerUser(String name, String lastName, String email, String password) {
        appUserService.registerAppUser(name, lastName, email, password);
    }

    @Override
    public void validateCredentials(String email, String password) {
        try {
            AppUser user = (AppUser) appUserService.loadUserByUsername(email);

            if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
                throw new InvalidCredentialsException("Invalid credentials");
            }
        } catch (UsernameNotFoundException e) {
            throw new UserNotFoundException("User with email: " + email + " was not found");
        }
    }

    @Override
    public String getJwtToken(String email) {
        AppUser user = (AppUser) appUserService.loadUserByUsername(email);
        String userRole = user.getRole().name();
        return jwtTokenProvider.getAccessToken(user.getEmail(), userRole);
    }
}
