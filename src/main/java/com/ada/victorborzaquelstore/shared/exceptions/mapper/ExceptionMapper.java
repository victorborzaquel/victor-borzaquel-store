package com.ada.victorborzaquelstore.shared.exceptions.mapper;

import com.ada.victorborzaquelstore.shared.exceptions.base.AppException;
import com.ada.victorborzaquelstore.shared.exceptions.dto.ResponseExceptionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExceptionMapper {

  ExceptionMapper INSTANCE = Mappers.getMapper(ExceptionMapper.class);

  @Mapping(target = "message", source = "appMessage")
  ResponseExceptionDTO toResponse(AppException exception);
}
