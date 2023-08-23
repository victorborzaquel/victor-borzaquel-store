package com.ada.victorborzaquelstore.modules.user;

import com.ada.victorborzaquelstore.modules.address.AddressEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Entity
@Data
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne()
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;

    @Column(name = "CPF", unique = true)
    private String cpf;
}
