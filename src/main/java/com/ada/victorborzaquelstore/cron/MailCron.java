package com.ada.victorborzaquelstore.cron;

import com.ada.victorborzaquelstore.modules.mail.MailEntity;
import com.ada.victorborzaquelstore.modules.mail.MailMapper;
import com.ada.victorborzaquelstore.repositories.MailRepository;
import com.ada.victorborzaquelstore.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MailCron {

  private final MailService mailService;
  private final MailRepository mailRepository;

  @Scheduled(cron = "0 * * * *")
  private void sendMail() {
    List<MailEntity> mails = this.mailService.findAllPending();

    mails.stream()
        .map(MailMapper.INSTANCE::toSend)
        .forEach(this.mailService::sendMail);
  }

}
