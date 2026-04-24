package br.fiap.com.AutoPecas.controller;

import br.fiap.com.AutoPecas.dto.ProdutoResumo;
import br.fiap.com.AutoPecas.entity.Produto;
import br.fiap.com.AutoPecas.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // CRUD
    @GetMapping
    public Page<Produto> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {

        Produto existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        existente.setEstoque(produto.getEstoque());

        return repository.save(existente);
    }

    @PostMapping
    public Produto salvar(@Valid @RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // 🔍 BUSCAS (OBRIGATÓRIO)
    @GetMapping("/buscar/nome")
    public List<Produto> buscarPorNome(@RequestParam String nome) {
        return repository.findByNomeContaining(nome);
    }

    @GetMapping("/buscar/preco")
    public List<Produto> buscarPorPreco(@RequestParam Double preco) {
        return repository.findByPrecoGreaterThan(preco);
    }

    @GetMapping("/buscar/categoria")
    public List<Produto> buscarPorCategoria(@RequestParam String categoria) {
        return repository.findByCategoriaNome(categoria);
    }

    @GetMapping("/resumo")
    public List<ProdutoResumo> resumo() {
        return repository.findBy();
    }
}
