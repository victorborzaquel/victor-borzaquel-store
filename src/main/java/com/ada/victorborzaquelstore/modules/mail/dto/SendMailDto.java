package com.ada.victorborzaquelstore.modules.mail.dto;

import com.ada.victorborzaquelstore.modules.mail.enums.MailStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendMailDto {

  @Email(message = "From must be a valid email")
  @NotEmpty(message = "From is required")
  private String from;

  @Email(message = "To must be a valid email")
  private String to;

  @NotEmpty(message = "Subject is required")
  private String subject;

  @NotEmpty(message = "Text is required")
  private String text;

  private MailStatus status;

  private LocalDateTime sendAt;
}
