package dbe.isep.diamniadio.parrainage.parrainage.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbe.isep.diamniadio.parrainage.parrainage.securityApp.UserApp;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){

        this.authenticationManager = authenticationManager;
    }
    @Override

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {

            InputStream requestBody = request.getInputStream();

            ObjectMapper objectMapper = new ObjectMapper();
            UserApp userCredentials = objectMapper.readValue(requestBody, UserApp.class);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());

            System.out.println(userCredentials.getPassword()+" ________________________"+userCredentials.getUsername()+"_____________________________");

            return authenticationManager.authenticate(authenticationToken);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User)authResult.getPrincipal();

        // Générer le JWT
        Algorithm algorithm = Algorithm.HMAC256("mySecret123");
        String jwtAccessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))//Date de validite a 30 minutes
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.toList()))
                .sign(algorithm);

        //Rafraichir le token
        String jwtRefreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 15 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        Map<String, String> idToken = new HashMap<>();
        idToken.put("access-token ", jwtAccessToken);
        idToken.put("refresh-token ", jwtRefreshToken);

        // Ajouter le jeton JWT à l'en-tête de la réponse
        //response.addHeader("Authorization", "Bearer " + jwtAccessToken);

        //response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + idToken + "\"}");
        response.getWriter().flush();
        System.out.println("Vous etes bien authentifier "+ jwtAccessToken);
    }



}
