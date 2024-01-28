package demo.demo.config.jwt;

import demo.demo.entity.AppUser;
import demo.demo.service.AppUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@RequiredArgsConstructor
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtProvider jwtProvider;
    private final AppUserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final AppUser user = (AppUser) authentication.getPrincipal();
        String userRole = user.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("");

        final String accessToken = jwtProvider.getAccessToken(
                userService.loadUserByUsername(user.getEmail()).toString(), userRole);

        response.setHeader("access_token", accessToken);
    }
}


