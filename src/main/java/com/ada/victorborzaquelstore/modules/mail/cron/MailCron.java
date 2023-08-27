package com.ada.victorborzaquelstore.modules.mail.cron;

import com.ada.victorborzaquelstore.modules.mail.entities.MailEntity;
import com.ada.victorborzaquelstore.modules.mail.enums.MailStatus;
import com.ada.victorborzaquelstore.modules.mail.mapper.MailMapper;
import com.ada.victorborzaquelstore.modules.mail.providers.MailProvider;
import com.ada.victorborzaquelstore.modules.mail.repositories.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MailCron {

  private final MailProvider mailProvider;
  private final MailRepository mailRepository;

  @Scheduled(cron = "0 * * * *")
  private void sendMail() {
    List<MailEntity> mails = this.mailRepository.findAllByStatus(MailStatus.PENDING);

    mails.stream()
        .map(MailMapper.INSTANCE::toSend)
        .forEach(this.mailProvider::sendMail);
  }

}
