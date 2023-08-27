package com.ada.victorborzaquelstore.modules.mail.services;

import com.ada.victorborzaquelstore.modules.mail.dto.CreateMailDto;
import com.ada.victorborzaquelstore.modules.mail.dto.ResponseMailDto;
import com.ada.victorborzaquelstore.modules.mail.entities.MailEntity;
import com.ada.victorborzaquelstore.modules.mail.mapper.MailMapper;
import com.ada.victorborzaquelstore.modules.mail.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService {

  private final MailRepository mailRepository;

  public ResponseMailDto create(CreateMailDto dto) {
    MailEntity mail = MailMapper.INSTANCE.toEntity(dto);

    MailEntity response = mailRepository.save(mail);

    return MailMapper.INSTANCE.toResponse(response);
  }

}
