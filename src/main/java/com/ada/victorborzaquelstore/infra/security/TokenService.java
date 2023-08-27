package com.ada.victorborzaquelstore.infra.security;

import com.ada.victorborzaquelstore.modules.user.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
  //  @Value("${api.security.token.secret}")
  private String secret = "123";

  public String generateToken(UserEntity user) {
    try {
      return JWT.create()
          .withIssuer("victor-borzaquel-store")
          .withSubject(user.getUsername())
          .withExpiresAt(genExpirationDate())
          .sign(Algorithm.HMAC256(secret));
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Error while generating token", exception);
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .withIssuer("victor-borzaquel-store")
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException exception) {
      return "";
    }
  }

  private Instant genExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
