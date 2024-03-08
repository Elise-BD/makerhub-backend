package technobel.formation.pip_backend.pl.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import technobel.formation.pip_backend.dal.entities.User;
import technobel.formation.pip_backend.dal.enums.Role;

import java.time.Instant;

@Component
public class JWTProvider {

    //jwt signature
    private static final String JWT_SECRET = "c!Rx4s%+Q5WaSgb>5GE=G108E7N.UKs_Vm||LTZQyfc[V/05-D";
    //validity time period
    private static final long EXPIRES_AT = 900_000;
    //header name
    private static final String AUTH_HEADER = "Authorization";
    //type
    private static final String TOKEN_PREFIX = "Bearer ";

    private final UserDetailsService userDetailsService;


    public JWTProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String generateToken(String username, Role role) {
        return TOKEN_PREFIX + JWT.create()
                .withSubject(username)
                .withClaim("role", role.toString())
                .withExpiresAt(Instant.now().plusMillis(EXPIRES_AT))
                .sign(Algorithm.HMAC512(JWT_SECRET));
    }

    public String extractToken(HttpServletRequest request) {
        String header = request.getHeader(AUTH_HEADER);

        if (header == null || !header.startsWith(TOKEN_PREFIX))
            return null;

        return header.replaceFirst(TOKEN_PREFIX, "");
    }

    public boolean validateToken(String token) {

        try {

            //1 vérifier que le bon JWT_SECRET ait été utilisé (le même algorithme de cryptage)
            //2 vérifier que le token ne soit pas expiré
            DecodedJWT jwt = JWT.require(Algorithm.HMAC512(JWT_SECRET))
                    .acceptExpiresAt(EXPIRES_AT)
                    .withClaimPresence("sub")
                    .withClaimPresence("role")
                    .build()
                    .verify(token);

            //3 créer le token à partir d'un User existant (et actif)
            String username = jwt.getSubject();
            User user = (User) userDetailsService.loadUserByUsername(username);
            if (!user.isEnabled())
                return false;

            //4 vérifier les rôles (facultatif)
            Role tokenRole = jwt.getClaim("role").as(Role.class);

            return user.getRole().equals(tokenRole);

        } catch (JWTVerificationException | UsernameNotFoundException ex) {
            return false;
        }
    }

    public Authentication createAuthentication(String token) {
        DecodedJWT jwt = JWT.decode(token);

        String username = jwt.getSubject();

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                null,
                userDetails.getAuthorities()
        );
    }
}
