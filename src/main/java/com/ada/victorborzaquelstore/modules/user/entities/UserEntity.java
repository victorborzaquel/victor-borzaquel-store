package com.ada.victorborzaquelstore.modules.user.entities;

import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import com.ada.victorborzaquelstore.modules.employee.entities.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.user.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "unique_per_employee", columnNames = {"id", "employee_id"}),
        @UniqueConstraint(name = "unique_per_client", columnNames = {"id", "client_id"}),
    }
)
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Column(name = "cpf", unique = true, nullable = false)
  private String cpf;

  @Enumerated(STRING)
  @Builder.Default
  private UserRole role = UserRole.CLIENT;

  @OneToOne
  @JoinColumn(name = "employee_id", updatable = false)
  private EmployeeEntity employee;

  @OneToOne
  @JoinColumn(name = "client_id", updatable = false)
  private ClientEntity client;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return this.passwordHash;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
