package com.ada.victorborzaquelstore.shared.providers.mail.impl;

import com.ada.victorborzaquelstore.shared.providers.mail.models.MailProvider;
import com.ada.victorborzaquelstore.shared.providers.mail.dto.MailProviderDTO;

public class JavaMailProvider implements MailProvider {
  public void sendMail(MailProviderDTO dto) {
    System.out.println("Sending mail to " + dto.getTo());
    System.out.println("Subject: " + dto.getSubject());
    System.out.println("Body: " + dto.getText());
  }
}
