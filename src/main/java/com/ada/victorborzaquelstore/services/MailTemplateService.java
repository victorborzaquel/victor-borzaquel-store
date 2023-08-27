package com.ada.victorborzaquelstore.services;

import com.ada.victorborzaquelstore.modules.mail.dto.CreateMailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailTemplateService {

  private final MailService mailService;

  public void clientBuyOrderEmailToClient(String to) {
    CreateMailDto mail = CreateMailDto.builder()
        .from("victor@mail.com")
        .to(to)
        .subject("Compra realizada com sucesso!")
        .text("Sua compra foi realizada com sucesso!")
        .build();

    this.mailService.create(mail);
  }

  public void clientBuyOrderEmailToSalesManager(String to) {
    CreateMailDto mail = CreateMailDto.builder()
        .from("victor@mail.com")
        .to(to)
        .subject("Um novo pedido foi realizado!")
        .text("Um novo pedido foi realizado!")
        .build();

    this.mailService.create(mail);
  }

}
