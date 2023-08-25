package com.ada.victorborzaquelstore.modules.user.services;

import com.ada.victorborzaquelstore.modules.user.dto.CreateUserDTO;
import com.ada.victorborzaquelstore.modules.user.dto.ResponseUserDTO;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import com.ada.victorborzaquelstore.modules.user.mappers.UserMapper;
import com.ada.victorborzaquelstore.modules.user.repositories.UserRepository;
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

  public ResponseUserDTO create(CreateUserDTO createUserDto) {
    UserEntity entity = userMapper.toEntity(createUserDto);
    UserEntity response = userRepository.save(entity);
    return userMapper.toDto(response);
  }

}
