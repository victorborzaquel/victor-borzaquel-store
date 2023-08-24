package com.ada.victorborzaquelstore.api.v1;

import com.ada.victorborzaquelstore.modules.user.dto.CreateUserDto;
import com.ada.victorborzaquelstore.modules.user.dto.ResponseUserDto;
import com.ada.victorborzaquelstore.modules.user.UserService;
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
  public ResponseUserDto create(@RequestBody CreateUserDto createUserDto) {
    return userService.create(createUserDto);
  }

}
