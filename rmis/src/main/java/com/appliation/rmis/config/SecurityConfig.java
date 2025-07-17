package com.appliation.rmis.config;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Elements.JWT;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//
//    @Value("${jwt.secret}")
//    private String jwtSecret;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    public String generateJwtToken(String email, String role) {
//        return Jwts.builder()
//                .setSubject(email)
//                .claim("role", role)
//                .setExpiration(new java.util.Date(System.currentTimeMillis() + 86400000))
//                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
//                .compact();
//    }
}