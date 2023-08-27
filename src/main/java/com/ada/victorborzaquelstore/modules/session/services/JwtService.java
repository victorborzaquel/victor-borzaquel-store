package com.ada.victorborzaquelstore.modules.session.services;

import com.ada.victorborzaquelstore.shared.utils.DateUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class JwtService {

  private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  public String generateToken(String username) {
    Date now = DateUtil.convert(LocalDateTime.now());
    Date expiration = DateUtil.convert(LocalDateTime.now().plusHours(1));

    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(now)
        .setExpiration(expiration)
        .signWith(secretKey)
        .compact();
  }

  public String getSubject(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  public boolean isTokenValid(String token) {
    try {
      Jwts.parserBuilder()
          .setSigningKey(secretKey)
          .build()
          .isSigned(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
