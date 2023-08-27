package com.ada.victorborzaquelstore.shared.dto;

import com.ada.victorborzaquelstore.shared.exceptions.AppException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExceptionMapper {

  ExceptionMapper INSTANCE = Mappers.getMapper(ExceptionMapper.class);

  @Mapping(target = "message", source = "appMessage")
  ResponseExceptionDTO toResponse(AppException exception);
}
