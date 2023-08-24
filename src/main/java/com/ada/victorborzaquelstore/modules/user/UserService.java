package com.ada.victorborzaquelstore.modules.user;

import com.ada.victorborzaquelstore.modules.user.dto.CreateUserDto;
import com.ada.victorborzaquelstore.modules.user.dto.ResponseUserDto;
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

  public ResponseUserDto create(CreateUserDto createUserDto) {
    UserEntity entity = userMapper.toEntity(createUserDto);
    UserEntity response = userRepository.save(entity);
    return userMapper.toDto(response);
  }

}
