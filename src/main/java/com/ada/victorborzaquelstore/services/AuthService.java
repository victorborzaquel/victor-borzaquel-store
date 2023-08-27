package com.ada.victorborzaquelstore.services;

import com.ada.victorborzaquelstore.infra.security.TokenService;
import com.ada.victorborzaquelstore.modules.user.UserEntity;
import com.ada.victorborzaquelstore.modules.user.dto.LoginDTO;
import com.ada.victorborzaquelstore.modules.user.dto.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final TokenService tokenService;

  public TokenDTO login(LoginDTO dto) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

    Authentication auth = this.authenticationManager.authenticate(usernamePassword);

    String token = tokenService.generateToken((UserEntity) auth.getPrincipal());

    return new TokenDTO(token);
  }
}
