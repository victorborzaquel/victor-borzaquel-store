package com.ada.victorborzaquelstore.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
  public String currentSub() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
      return userDetails.getUsername();
    } else {
      return null;
    }
  }
}
