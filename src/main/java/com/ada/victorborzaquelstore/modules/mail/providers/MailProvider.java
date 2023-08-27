package com.ada.victorborzaquelstore.modules.mail.providers;

import com.ada.victorborzaquelstore.modules.mail.dto.SendMailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailProvider {

  private final JavaMailSender mailSender;

  public void sendMail(SendMailDto mail) throws MailException {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(mail.getFrom());
    message.setTo(mail.getTo());
    message.setSubject(mail.getSubject());
    message.setText(mail.getText());

    mailSender.send(message);
  }
}
