package com.ada.victorborzaquelstore.modules.address.services;

import com.ada.victorborzaquelstore.modules.address.dto.CreateAddressDTO;
import com.ada.victorborzaquelstore.modules.address.dto.ResponseAddressDTO;
import com.ada.victorborzaquelstore.modules.address.entities.AddressEntity;
import com.ada.victorborzaquelstore.modules.address.mappers.AddressMapper;
import com.ada.victorborzaquelstore.modules.address.repositories.AddressRepository;
import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import com.ada.victorborzaquelstore.modules.client.exceptions.ClientNotFoundException;
import com.ada.victorborzaquelstore.modules.client.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddressService {

  private final AddressRepository addressRepository;
  private final ClientRepository clientRepository;

  public ResponseAddressDTO create(CreateAddressDTO dto) {
    AddressEntity address = AddressMapper.INSTANCE.toEntity(dto);

    if (!clientRepository.existsById(dto.getClientId())) {
      throw new ClientNotFoundException();
    }

    AddressEntity response = addressRepository.save(address);
    return AddressMapper.INSTANCE.toDto(response);
  }

  public Page<ResponseAddressDTO> getAllByUser(UUID clientId, Pageable pageable) {
    Page<AddressEntity> addresses = this.addressRepository.findAllByClient(new ClientEntity(clientId), pageable);
    return addresses.map(AddressMapper.INSTANCE::toDto);
  }
}
