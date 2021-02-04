package com.ECommerce.ECommerce.repository;

import com.ECommerce.ECommerce.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
