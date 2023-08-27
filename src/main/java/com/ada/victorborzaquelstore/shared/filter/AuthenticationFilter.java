package com.ada.victorborzaquelstore.shared.filter;

import com.ada.victorborzaquelstore.modules.session.services.AuthService;
import com.ada.victorborzaquelstore.modules.session.services.JwtService;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final AuthService authService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
    String auth = request.getHeader("Authorization");

    if (auth != null) {

      String token = auth.replace("Bearer ", "").trim();

      if (this.jwtService.isTokenValid(token)) {
        String username = this.jwtService.getSubject(token);

        UserEntity user = (UserEntity) this.authService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            user.getUsername(),
            null,
            user.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    filterChain.doFilter(request, response);
  }
}
