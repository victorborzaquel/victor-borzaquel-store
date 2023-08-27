package com.ada.victorborzaquelstore.shared.exceptions.base;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException {
  private final LocalDateTime timestamp = LocalDateTime.now();
  private final Integer status;
  private final HttpStatus httpStatus;
  private final String reason;
  private final List<String> errors;
  private final String appMessage;

  public AppException(List<String> errors, HttpStatus httpStatus, String reason) {
    HttpStatus defaultHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    String defaultReason = "Error in the application";

    this.errors = new ArrayList<>(errors);
    this.appMessage = reason != null ? reason : defaultReason;
    this.httpStatus = httpStatus != null ? httpStatus : defaultHttpStatus;
    this.reason = httpStatus != null ? httpStatus.getReasonPhrase() : defaultHttpStatus.getReasonPhrase();
    this.status = httpStatus != null ? httpStatus.value() : defaultHttpStatus.value();
  }

  public AppException(HttpStatus httpStatus, String reason) {
    this(new ArrayList<>(), httpStatus, reason);
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public String getReason() {
    return reason;
  }

  public List<String> getErrors() {
    return errors;
  }

  public String getAppMessage() {
    return appMessage;
  }
}
