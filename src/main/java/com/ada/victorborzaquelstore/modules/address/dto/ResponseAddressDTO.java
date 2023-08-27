package com.ada.victorborzaquelstore.modules.address.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAddressDTO {
  private UUID id;
  private String street;
  private String number;
  private String complement;
  private String zipcode;
  private String city;
  private String state;
}
