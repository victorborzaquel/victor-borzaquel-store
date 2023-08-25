package com.ada.victorborzaquelstore.modules.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMailDto {
  private String from;
  private String to;
  private String subject;
  private String text;
}
