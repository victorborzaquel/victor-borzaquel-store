package com.ada.victorborzaquelstore.modules.session.services;

import com.ada.victorborzaquelstore.modules.session.dto.LoginDTO;
import com.ada.victorborzaquelstore.modules.session.dto.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  public TokenDTO login(LoginDTO dto) throws AuthenticationException {
    var authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

    Authentication authenticate = this.authenticationManager.authenticate(authenticationToken);

    if (authenticate.isAuthenticated()) {
      String jwtToken = this.jwtService.generateToken((String) authenticate.getPrincipal());

      return new TokenDTO(jwtToken, "Bearer");
    }

    return null;
  }

  public void logout() {

  }
}
