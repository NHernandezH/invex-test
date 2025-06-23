package com.invex.employees.infrastructure.repository;

import com.invex.employees.infrastructure.repository.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
