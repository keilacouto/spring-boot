package io.github.keilacouto.domain.repository;

import io.github.keilacouto.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
