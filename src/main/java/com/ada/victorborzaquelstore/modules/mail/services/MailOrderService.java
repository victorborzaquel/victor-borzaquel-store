package com.ada.victorborzaquelstore.modules.mail.services;

import com.ada.victorborzaquelstore.modules.mail.dto.CreateMailDto;
import com.ada.victorborzaquelstore.modules.mail.dto.ResponseMailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailOrderService {

  private final MailService mailService;

  public ResponseMailDto clientBuyOrderEmailToClient(String to) {
    CreateMailDto mail = CreateMailDto.builder()
        .from("victor@mail.com")
        .to(to)
        .subject("Compra realizada com sucesso!")
        .text("Sua compra foi realizada com sucesso!")
        .build();

    return this.mailService.create(mail);
  }

  public ResponseMailDto clientBuyOrderEmailToSalesManager(String to) {
    CreateMailDto mail = CreateMailDto.builder()
        .from("victor@mail.com")
        .to(to)
        .subject("Um novo pedido foi realizado!")
        .text("Um novo pedido foi realizado!")
        .build();

    return this.mailService.create(mail);
  }

}
