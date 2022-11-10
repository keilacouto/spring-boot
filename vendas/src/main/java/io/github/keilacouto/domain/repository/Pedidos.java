package io.github.keilacouto.domain.repository;

import io.github.keilacouto.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
