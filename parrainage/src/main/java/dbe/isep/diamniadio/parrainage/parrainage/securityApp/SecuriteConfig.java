package dbe.isep.diamniadio.parrainage.parrainage.securityApp;

import dbe.isep.diamniadio.parrainage.parrainage.filter.JwtAuthenticationFilter;
import dbe.isep.diamniadio.parrainage.parrainage.filter.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.*;

@Configuration
@EnableWebSecurity
public class SecuriteConfig {

    private  UserDetailServiceImp userDetailServiceImp;

    public SecuriteConfig(UserDetailServiceImp userDetailServiceImp){
        this.userDetailServiceImp = userDetailServiceImp;
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        System.out.println("AuthenticationManagerBuilder-------------_________________________________");
        builder.userDetailsService(userDetailServiceImp);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationConfiguration authenticationConfiguration) throws Exception {
        System.out.println("_________________________________filterChain");

        http.csrf((csrf) -> csrf.disable());
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/login").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/auth/addRole")
                        .hasAnyAuthority("ADMIN")//Seule l'admin a acces à cette route

                .anyRequest().authenticated()
        );
        http.addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()));
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
