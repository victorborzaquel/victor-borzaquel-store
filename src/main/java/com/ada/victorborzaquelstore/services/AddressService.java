package com.ada.victorborzaquelstore.services;

import com.ada.victorborzaquelstore.modules.address.AddressEntity;
import com.ada.victorborzaquelstore.modules.address.AddressMapper;
import com.ada.victorborzaquelstore.modules.address.dto.CreateAddressDTO;
import com.ada.victorborzaquelstore.modules.address.dto.ResponseAddressDTO;
import com.ada.victorborzaquelstore.repositories.AddressRepository;
import com.ada.victorborzaquelstore.modules.client.ClientEntity;
import com.ada.victorborzaquelstore.shared.exceptions.ClientNotFoundException;
import com.ada.victorborzaquelstore.repositories.ClientRepository;
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
