package com.ada.victorborzaquelstore.api.v1;

import com.ada.victorborzaquelstore.modules.session.dto.LoginDTO;
import com.ada.victorborzaquelstore.modules.session.dto.TokenDTO;
import com.ada.victorborzaquelstore.modules.session.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("session")
public class SessionController {

  private final SessionService sessionService;

  @PostMapping
  public TokenDTO login(@RequestBody LoginDTO dto) {
    return this.sessionService.login(dto);
  }
}
