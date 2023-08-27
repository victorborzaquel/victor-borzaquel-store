package com.ada.victorborzaquelstore.modules.session.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class SessionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
}
