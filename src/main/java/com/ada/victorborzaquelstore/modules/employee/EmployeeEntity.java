package com.ada.victorborzaquelstore.modules.employee;

import com.ada.victorborzaquelstore.modules.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id", unique = true, nullable = false)
  private UserEntity user;

  @Column(name = "department")
  @Enumerated(STRING)
  private DepartmentType department;

  @Column(name = "role", nullable = false)
  @Enumerated(STRING)
  @Builder.Default
  private EmployeeRole role = EmployeeRole.EMPLOYEE;
}
