package com.ada.victorborzaquelstore.modules.user.mapper;

import com.ada.victorborzaquelstore.modules.user.UserEntity;
import com.ada.victorborzaquelstore.modules.user.dto.UserRequestDto;
import com.ada.victorborzaquelstore.modules.user.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper
public interface UserMapper {
    UserEntity toEntity(UserRequestDto userRequestDto);

    UserResponseDto toResponseDto(UserEntity userEntity);
}
