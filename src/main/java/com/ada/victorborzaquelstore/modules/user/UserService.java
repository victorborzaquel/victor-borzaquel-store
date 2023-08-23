package com.ada.victorborzaquelstore.modules.user;

import com.ada.victorborzaquelstore.modules.user.dto.UserRequestDto;
import com.ada.victorborzaquelstore.modules.user.dto.UserResponseDto;
import com.ada.victorborzaquelstore.modules.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    public UserResponseDto create(UserRequestDto userRequestDto) {
        System.out.println(userRequestDto);
        UserEntity entity = userMapper.toEntity(userRequestDto);
        UserEntity response = userRepository.save(entity);
        return userMapper.toResponseDto(response);
    }
}
