package com.ada.victorborzaquelstore.api.v1;

import com.ada.victorborzaquelstore.modules.user.dto.CreateUserDTO;
import com.ada.victorborzaquelstore.modules.user.dto.ResponseUserDTO;
import com.ada.victorborzaquelstore.modules.user.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseUserDTO create(@RequestBody CreateUserDTO createUserDto) {
    return userService.create(createUserDto);
  }

}
