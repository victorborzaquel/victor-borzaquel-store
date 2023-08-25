package com.ada.victorborzaquelstore.modules.user.mappers;

import com.ada.victorborzaquelstore.modules.user.dto.CreateUserDTO;
import com.ada.victorborzaquelstore.modules.user.dto.ResponseUserDTO;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
  UserEntity toEntity(CreateUserDTO createUserDto);

  ResponseUserDTO toDto(UserEntity userEntity);
}
