package com.ada.victorborzaquelstore.modules.address;

import com.ada.victorborzaquelstore.modules.user.UserEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;
}
