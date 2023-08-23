package com.ada.victorborzaquelstore.modules.user.mapper;

import com.ada.victorborzaquelstore.modules.user.UserEntity;
import com.ada.victorborzaquelstore.modules.user.dto.UserRequestDto;
import com.ada.victorborzaquelstore.modules.user.dto.UserResponseDto;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public interface UserMapper {
    UserEntity toEntity(UserRequestDto userRequestDto);

    UserEntity toEntity(UUID id, UserResponseDto userResponseDto);

    UserResponseDto toResponseDto(UserEntity userEntity);
}