package com.ada.victorborzaquelstore.services;

import com.ada.victorborzaquelstore.modules.mail.MailEntity;
import com.ada.victorborzaquelstore.modules.mail.MailMapper;
import com.ada.victorborzaquelstore.modules.mail.MailStatus;
import com.ada.victorborzaquelstore.modules.mail.dto.CreateMailDto;
import com.ada.victorborzaquelstore.modules.mail.dto.ResponseMailDto;
import com.ada.victorborzaquelstore.modules.mail.dto.SendMailDto;
import com.ada.victorborzaquelstore.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MailService {

  private final MailRepository mailRepository;

  private final JavaMailSender mailSender;

  public void sendMail(SendMailDto mail) throws MailException {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(mail.getFrom());
    message.setTo(mail.getTo());
    message.setSubject(mail.getSubject());
    message.setText(mail.getText());

    mailSender.send(message);
  }

  public ResponseMailDto create(CreateMailDto dto) {
    MailEntity mail = MailMapper.INSTANCE.toEntity(dto);

    MailEntity response = mailRepository.save(mail);

    return MailMapper.INSTANCE.toResponse(response);
  }

  public List<MailEntity> findAllPending() {
    return this.mailRepository.findAllByStatus(MailStatus.PENDING);
  }
}
