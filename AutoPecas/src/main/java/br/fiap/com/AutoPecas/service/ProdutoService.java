package br.fiap.com.AutoPecas.service;

import br.fiap.com.AutoPecas.entity.Produto;
import br.fiap.com.AutoPecas.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Page<Produto> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto buscar(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
