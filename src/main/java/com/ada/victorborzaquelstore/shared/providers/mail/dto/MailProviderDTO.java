package com.ada.victorborzaquelstore.shared.providers.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailProviderDTO {
  private String to;
  private String subject;
  private String text;
}
