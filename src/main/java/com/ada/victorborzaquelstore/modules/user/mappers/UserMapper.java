package com.ada.victorborzaquelstore.modules.user.mappers;

import com.ada.victorborzaquelstore.modules.client.dto.CreateClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.UpdateClientDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.CreateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.UpdateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserEntity toEntity(CreateClientDTO dto);

  UserEntity toEntity(UpdateClientDTO dto);

  @Mapping(target = "role", ignore = true)
  UserEntity toEntity(CreateEmployeeDTO dto);

  @Mapping(target = "id", ignore = true)
  void updateFromDto(@MappingTarget UserEntity target, UpdateClientDTO dto);

  @Mapping(target = "id", ignore = true)
  void updateFromDto(@MappingTarget UserEntity target, UpdateEmployeeDTO dto);

}
