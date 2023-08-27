package com.ada.victorborzaquelstore.modules.client.services;

import com.ada.victorborzaquelstore.modules.client.dto.CreateClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.ResponseClientDTO;
import com.ada.victorborzaquelstore.modules.client.dto.UpdateClientDTO;
import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import com.ada.victorborzaquelstore.modules.client.exceptions.ClientNotFoundException;
import com.ada.victorborzaquelstore.modules.client.mappers.ClientMapper;
import com.ada.victorborzaquelstore.modules.client.repositories.ClientDslRepository;
import com.ada.victorborzaquelstore.modules.client.repositories.ClientRepository;
import com.ada.victorborzaquelstore.modules.user.entities.UserEntity;
import com.ada.victorborzaquelstore.modules.user.enums.UserRole;
import com.ada.victorborzaquelstore.modules.user.mappers.UserMapper;
import com.ada.victorborzaquelstore.shared.exceptions.AlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientDslRepository clientDslRepository;
  private final PasswordEncoder passwordEncoder;

  private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  public ResponseClientDTO create(CreateClientDTO dto) {
    this.checkForDuplicateUniqueFields(dto);

    ClientEntity client = this.clientMapper.toEntity(dto);
    UserEntity user = this.userMapper.toEntity(dto);

    user.setPasswordHash(this.passwordEncoder.encode(dto.getPassword()));
    client.setUser(user);
    user.setRole(UserRole.CLIENT);

    ClientEntity response = this.clientRepository.save(client);
    return this.clientMapper.toResponse(response);
  }

  public ResponseClientDTO update(UUID id, UpdateClientDTO dto) {
    this.checkForDuplicateUniqueFields(id, dto);

    ClientEntity client = this.clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);

    this.userMapper.updateFromDto(client.getUser(), dto);

    ClientEntity response = this.clientRepository.save(client);
    return this.clientMapper.toResponse(response);
  }

  public ResponseClientDTO getOne(UUID id) {
    ClientEntity client = this.clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    return this.clientMapper.toResponse(client);
  }

  public Page<ResponseClientDTO> getAll(Pageable pageable) {
    Page<ClientEntity> clients = this.clientRepository.findAll(pageable);
    return clients.map(this.clientMapper::toResponse);
  }

  public void delete(UUID id) {
    this.clientRepository.deleteById(id);
  }

  private void checkForDuplicateUniqueFields(CreateClientDTO dto) {
    List<String> errors = new ArrayList<>();

    if (clientDslRepository.existsByUserEmail(dto.getEmail())) {
      errors.add("Email already exists");
    }

    if (clientDslRepository.existsByUserUsername(dto.getUsername())) {
      errors.add("Username already exists");
    }

    if (clientDslRepository.existsByUserCpf(dto.getCpf())) {
      errors.add("CPF already exists");
    }

    if (!errors.isEmpty()) {
      throw new AlreadyExistsException(errors, "Employee already exists");
    }
  }

  private void checkForDuplicateUniqueFields(UUID id, UpdateClientDTO dto) {
    List<String> errors = new ArrayList<>();

    if (clientDslRepository.existsByUserEmail(dto.getEmail(), id)) {
      errors.add("Email already exists");
    }

    if (!errors.isEmpty()) {
      throw new AlreadyExistsException(errors, "Employee already exists");
    }
  }
}
