package com.ada.victorborzaquelstore.config;

import com.ada.victorborzaquelstore.shared.providers.mail.impl.JavaMailProvider;
import com.ada.victorborzaquelstore.shared.providers.mail.models.MailProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfig {
  @Bean
  public MailProvider mailProvider() {
    return new JavaMailProvider();
  }
}
