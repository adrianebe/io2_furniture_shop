package demo.demo.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Component
public class JwtTokenProvider implements JwtProvider {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public JwtTokenProvider() {
        this.algorithm = Algorithm.HMAC256("not a secret".getBytes(StandardCharsets.UTF_8));
        this.verifier = JWT.require(algorithm).build();
    }

    @Override
    public String getAccessToken(String userId, String role) {
        return JWT.create()
                .withSubject(userId)
                .withClaim("role", role)
                .sign(algorithm);
    }

    @Override
    public UsernamePasswordAuthenticationToken extractAuthentication(String token) {
        DecodedJWT jwt = verifier.verify(token);
        String role = jwt.getClaim("role").asString();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);

        return new UsernamePasswordAuthenticationToken(
                jwt.getSubject(),
                null,
                Collections.singletonList(authority)
        );
    }
}
