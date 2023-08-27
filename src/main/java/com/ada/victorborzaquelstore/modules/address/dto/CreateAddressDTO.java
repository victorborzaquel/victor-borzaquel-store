package com.ada.victorborzaquelstore.modules.address.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressDTO {

  @NotNull(message = "Client id is required")
  private UUID clientId;

  @NotEmpty(message = "Street is required")
  private String street;

  @NotEmpty(message = "Number is required")
  private String number;

  private String complement;

  @NotEmpty(message = "Zipcode is required")
  @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Invalid zipcode")
  private String zipcode;

  @NotEmpty(message = "City is required")
  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid city")
  private String city;

  @NotEmpty(message = "State is required")
  @Pattern(regexp = "^(?:[a-zA-Z]\\s?)+$", message = "Invalid state")
  private String state;
}
