package br.fiap.com.AutoPecas.repository;

import br.fiap.com.AutoPecas.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}