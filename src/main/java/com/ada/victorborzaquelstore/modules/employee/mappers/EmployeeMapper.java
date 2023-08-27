package com.ada.victorborzaquelstore.modules.employee.mappers;

import com.ada.victorborzaquelstore.modules.employee.dto.CreateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.ResponseEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.UpdateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  @Mapping(source = "user.firstName", target = "firstName")
  @Mapping(source = "user.lastName", target = "lastName")
  @Mapping(source = "user.cpf", target = "cpf")
  @Mapping(source = "user.email", target = "email")
  @Mapping(source = "user.username", target = "username")
  ResponseEmployeeDTO toResponse(EmployeeEntity entity);

  EmployeeEntity toEntity(CreateEmployeeDTO dto);

  EmployeeEntity toEntity(UpdateEmployeeDTO dto);
}
