package com.ada.victorborzaquelstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VictorBorzaquelStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(VictorBorzaquelStoreApplication.class, args);
    }

}
