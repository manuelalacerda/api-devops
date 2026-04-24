package br.fiap.com.AutoPecas.repository;

import br.fiap.com.AutoPecas.dto.ProdutoResumo;
import br.fiap.com.AutoPecas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContaining(String nome);

    List<Produto> findByPrecoGreaterThan(Double preco);

    List<Produto> findByCategoriaNome(String nomeCategoria);

    List<ProdutoResumo> findBy();
}
