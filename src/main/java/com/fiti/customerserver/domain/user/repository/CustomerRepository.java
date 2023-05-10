package com.fiti.customerserver.domain.user.repository;

import com.fiti.customerserver.domain.user.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Long id);
    boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
}
