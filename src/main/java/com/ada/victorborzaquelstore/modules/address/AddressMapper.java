package com.ada.victorborzaquelstore.modules.address;

import com.ada.victorborzaquelstore.modules.address.dto.CreateAddressDTO;
import com.ada.victorborzaquelstore.modules.address.dto.ResponseAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

  AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

  ResponseAddressDTO toDto(AddressEntity entity);

  @Mapping(target = "client.id", source = "clientId")
  AddressEntity toEntity(CreateAddressDTO dto);

}
