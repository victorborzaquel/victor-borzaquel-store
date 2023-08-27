package com.ada.victorborzaquelstore.modules.address.controllers;

import com.ada.victorborzaquelstore.modules.address.dto.CreateAddressDTO;
import com.ada.victorborzaquelstore.modules.address.dto.ResponseAddressDTO;
import com.ada.victorborzaquelstore.modules.address.services.AddressService;
import com.ada.victorborzaquelstore.shared.utils.PageableUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

  private final AddressService addressService;

  @PostMapping
  public ResponseAddressDTO create(@Valid @RequestBody CreateAddressDTO dto) {
    return addressService.create(dto);
  }

  @GetMapping("client/{clientId}")
  public Page<ResponseAddressDTO> getAllByUser(@PathVariable UUID clientId, @RequestParam(required = false) Pageable pageable) {
    return addressService.getAllByUser(clientId, PageableUtil.getPageable(pageable));
  }

}
