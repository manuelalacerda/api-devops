package br.fiap.com.AutoPecas.repository;

import br.fiap.com.AutoPecas.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
