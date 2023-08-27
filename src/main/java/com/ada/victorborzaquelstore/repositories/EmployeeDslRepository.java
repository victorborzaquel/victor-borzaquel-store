package com.ada.victorborzaquelstore.repositories;

import com.ada.victorborzaquelstore.modules.employee.EmployeeEntity;
import com.ada.victorborzaquelstore.modules.employee.QEmployeeEntity;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EmployeeDslRepository extends QuerydslRepositorySupport {
  public EmployeeDslRepository() {
    super(EmployeeEntity.class);
  }

  public boolean existsByUserCpf(String cpf, UUID id) {
    if (cpf == null) {
      return false;
    }

    QEmployeeEntity employee = QEmployeeEntity.employeeEntity;

    BooleanExpression expression = employee.user.cpf.eq(cpf);

    if (id != null) {
      expression = expression.and(employee.id.ne(id));
    }

    return new JPAQueryFactory(getEntityManager())
        .selectFrom(employee)
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

    QEmployeeEntity employee = QEmployeeEntity.employeeEntity;

    BooleanExpression expression = employee.user.email.eq(email);

    if (id != null) {
      expression = expression.and(employee.id.ne(id));
    }

    return new JPAQueryFactory(getEntityManager())
        .selectFrom(employee)
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

    QEmployeeEntity employee = QEmployeeEntity.employeeEntity;

    BooleanExpression expression = employee.user.username.eq(username);

    if (id != null) {
      expression = expression.and(employee.id.ne(id));
    }

    return new JPAQueryFactory(getEntityManager())
        .selectFrom(employee)
        .where(expression)
        .fetchCount() > 0;
  }

  public boolean existsByUserUsername(String username) {
    return this.existsByUserUsername(username, null);
  }
}
