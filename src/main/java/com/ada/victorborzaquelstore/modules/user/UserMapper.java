package com.ada.victorborzaquelstore.modules.user;

import com.ada.victorborzaquelstore.modules.user.dto.CreateUserDto;
import com.ada.victorborzaquelstore.modules.user.dto.ResponseUserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
  UserEntity toEntity(CreateUserDto createUserDto);

  ResponseUserDto toDto(UserEntity userEntity);
}
