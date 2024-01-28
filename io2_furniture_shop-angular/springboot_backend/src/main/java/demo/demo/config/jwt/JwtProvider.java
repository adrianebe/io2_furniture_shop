package demo.demo.config.jwt;

import org.springframework.security.core.Authentication;

public interface JwtProvider {

    String getAccessToken(String userId, String role);

    Authentication extractAuthentication(String token);
}
