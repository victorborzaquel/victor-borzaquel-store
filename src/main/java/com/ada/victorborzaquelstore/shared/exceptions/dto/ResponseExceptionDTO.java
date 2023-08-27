package com.ada.victorborzaquelstore.shared.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseExceptionDTO {
  private LocalDateTime timestamp;
  private String reason;
  private Integer status;
  private String message;
  private List<String> errors;
}
