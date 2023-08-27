package com.ada.victorborzaquelstore.modules.mail;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mails")
public class MailEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "mail_from")
  private String from;

  @Column(name = "mail_to")
  private String to;

  @Column(name = "mail_subject")
  private String subject;

  @Column(name = "mail_text", columnDefinition = "TEXT")
  private String text;

  @Column(name = "send_at")
  private LocalDateTime sendAt;

  @Enumerated(STRING)
  @Builder.Default
  @Column(name = "status")
  private MailStatus status = MailStatus.PENDING;
}
