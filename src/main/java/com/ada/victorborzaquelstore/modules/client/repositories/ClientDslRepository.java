package com.ada.victorborzaquelstore.modules.client.repositories;

import com.ada.victorborzaquelstore.modules.client.entities.ClientEntity;
import com.ada.victorborzaquelstore.modules.client.entities.QClientEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClientDslRepository extends QuerydslRepositorySupport {
  public ClientDslRepository() {
    super(ClientEntity.class);
  }

  public boolean existsByUserCpf(String cpf, UUID id) {
    if (cpf == null) {
      return false;
    }

    QClientEntity entity = QClientEntity.clientEntity;

    BooleanExpression expression = entity.user.cpf.eq(cpf);

    if (id != null) {
      expression = expression.and(entity.id.ne(id));
    }

    return new JPAQueryFactory(getEntityManager())
        .selectFrom(entity)
        .where(expression)
        .fetchCount() > 0;
  }

  public boolean existsByUserCpf(String cpf) {
    return this.existsByUserCpf(cpf, null);
  }

  public boolean existsByUserEmail(String email, UUID id) {
    if (email == null) {
      return false;
    }

    QClientEntity entity = QClientEntity.clientEntity;

    BooleanExpression expression = entity.user.email.eq(email);

    if (id != null) {
      expression = expression.and(entity.id.ne(id));
    }

    return new JPAQueryFactory(getEntityManager())
        .selectFrom(entity)
        .where(expression)
        .fetchCount() > 0;
  }

  public boolean existsByUserEmail(String email) {
    return this.existsByUserEmail(email, null);
  }

  public boolean existsByUserUsername(String username, UUID id) {
    if (username == null) {
      return false;
    }

    QClientEntity entity = QClientEntity.clientEntity;

    BooleanExpression expression = entity.user.username.eq(username);

    if (id != null) {
      expression = expression.and(entity.id.ne(id));
    }

    return new JPAQueryFactory(getEntityManager())
        .selectFrom(entity)
        .where(expression)
        .fetchCount() > 0;
  }

  public boolean existsByUserUsername(String username) {
    return this.existsByUserUsername(username, null);
  }
}
