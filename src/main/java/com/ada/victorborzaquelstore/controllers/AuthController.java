package com.ada.victorborzaquelstore.controllers;

import com.ada.victorborzaquelstore.modules.user.dto.LoginDTO;
import com.ada.victorborzaquelstore.modules.user.dto.TokenDTO;
import com.ada.victorborzaquelstore.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public TokenDTO login(@RequestBody @Valid LoginDTO dto) {
    return this.authService.login(dto);
  }

}
