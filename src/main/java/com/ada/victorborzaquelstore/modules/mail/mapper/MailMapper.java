package com.ada.victorborzaquelstore.modules.mail.mapper;

import com.ada.victorborzaquelstore.modules.mail.dto.CreateMailDto;
import com.ada.victorborzaquelstore.modules.mail.dto.ResponseMailDto;
import com.ada.victorborzaquelstore.modules.mail.dto.SendMailDto;
import com.ada.victorborzaquelstore.modules.mail.entities.MailEntity;
import org.mapstruct.factory.Mappers;

public interface MailMapper {

  MailMapper INSTANCE = Mappers.getMapper(MailMapper.class);

  ResponseMailDto toResponse(MailEntity entity);

  SendMailDto toSend(MailEntity entity);

  MailEntity toEntity(CreateMailDto dto);

}
