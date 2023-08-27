package com.ada.victorborzaquelstore.modules.mail.repositories;

import com.ada.victorborzaquelstore.modules.mail.entities.MailEntity;
import com.ada.victorborzaquelstore.modules.mail.enums.MailStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MailRepository extends JpaRepository<MailEntity, UUID> {
  List<MailEntity> findAllByStatus(MailStatus status);
}
