package com.ada.victorborzaquelstore.modules.employee.controllers;

import com.ada.victorborzaquelstore.modules.employee.dto.CreateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.ResponseEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.dto.UpdateEmployeeDTO;
import com.ada.victorborzaquelstore.modules.employee.services.EmployeeService;
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
@RequestMapping("/api/v1/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  @PostMapping
  public ResponseEmployeeDTO create(@Valid @RequestBody CreateEmployeeDTO dto) {
    return this.employeeService.create(dto);
  }

  @PutMapping("/{id}")
  public ResponseEmployeeDTO update(@PathVariable UUID id, @Valid @RequestBody UpdateEmployeeDTO dto) {
    return this.employeeService.update(id, dto);
  }

  @GetMapping("/{id}")
  public ResponseEmployeeDTO getOne(@PathVariable UUID id) {
    return this.employeeService.getOne(id);
  }

  @GetMapping
  public Page<ResponseEmployeeDTO> getAll(@RequestParam(required = false) Pageable pageable) {
    return this.employeeService.getAll(PageableUtil.getPageable(pageable));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    this.employeeService.delete(id);
  }
}
