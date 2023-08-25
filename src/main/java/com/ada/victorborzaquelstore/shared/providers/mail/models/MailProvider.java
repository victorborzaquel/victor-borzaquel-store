package com.ada.victorborzaquelstore.shared.providers.mail.models;

import com.ada.victorborzaquelstore.shared.providers.mail.dto.MailProviderDTO;

public interface MailProvider {
  void sendMail(MailProviderDTO dto);
}
