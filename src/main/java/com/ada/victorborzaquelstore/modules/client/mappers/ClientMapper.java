package com.ada.victorborzaquelstore.modules.client.mappers;

import com.ada.victorborzaquelstore.modules.client.dto.CreateClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.ResponseClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.UpdateClientDTO;
import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  @Mapping(source = "user.firstName", target = "firstName")
  @Mapping(source = "user.lastName", target = "lastName")
  @Mapping(source = "user.cpf", target = "cpf")
  @Mapping(source = "user.email", target = "email")
  @Mapping(source = "user.username", target = "username")
  ResponseClientDTO toResponse(ClientEntity entity);

  ClientEntity toEntity(CreateClientDTO dto);

  ClientEntity toEntity(UpdateClientDTO dto);
}
