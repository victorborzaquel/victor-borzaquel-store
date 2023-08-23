package com.ada.victorborzaquelstore.api.v1;

import com.ada.victorborzaquelstore.modules.user.dto.UserRequestDto;
import com.ada.victorborzaquelstore.modules.user.dto.UserResponseDto;
import com.ada.victorborzaquelstore.modules.user.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
        return userService.create(userRequestDto);
    }

}
