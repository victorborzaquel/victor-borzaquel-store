package com.ada.victorborzaquelstore.modules.mail.dto;

import com.ada.victorborzaquelstore.modules.mail.MailStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseMailDto {

  private UUID id;
  private String from;
  private String to;
  private String subject;
  private String text;
  private MailStatus status;
  private LocalDateTime sendAt;

}
