package com.ECommerce.ECommerce.repository;

import com.ECommerce.ECommerce.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
