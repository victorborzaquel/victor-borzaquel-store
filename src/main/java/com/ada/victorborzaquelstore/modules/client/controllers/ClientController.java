package com.ada.victorborzaquelstore.modules.client.controllers;

import com.ada.victorborzaquelstore.modules.client.dto.CreateClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.ResponseClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.UpdateClientDTO;
import com.ada.victorborzaquelstore.modules.client.services.ClientService;
import com.ada.victorborzaquelstore.shared.utils.PageableUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

  private final ClientService clientService;

  @PostMapping
  public ResponseClientDTO create(@Valid @RequestBody CreateClientDTO dto) {
    return this.clientService.create(dto);
  }

  @PutMapping("/{id}")
  public ResponseClientDTO update(@PathVariable UUID id, @Valid @RequestBody UpdateClientDTO dto) {
    return this.clientService.update(id, dto);
  }

  @GetMapping("/{id}")
  public ResponseClientDTO getOne(@PathVariable UUID id) {
    return this.clientService.getOne(id);
  }

  @GetMapping
  public Page<ResponseClientDTO> getAll(@RequestParam(required = false) Pageable pageable) {
    return this.clientService.getAll(PageableUtil.getPageable(pageable));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    this.clientService.delete(id);
  }
}
