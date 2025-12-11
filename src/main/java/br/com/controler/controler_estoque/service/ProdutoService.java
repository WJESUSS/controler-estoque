package br.com.controler.controler_estoque.service;

import br.com.controler.controler_estoque.dto.ProdutoDTO;
import br.com.controler.controler_estoque.model.Produto;
import br.com.controler.controler_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @Transactional
    public Produto salvar(ProdutoDTO dto) {
        Produto produto = Produto.builder()
                .nome(dto.nome())
                .preco(dto.preco())
                .quantidade(dto.quantidade())
                .descricao(dto.descricao())
                .build();
        return repository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long id, ProdutoDTO dto) {
        Produto produto = buscarPorId(id);
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setQuantidade(dto.quantidade());
        produto.setDescricao(dto.descricao());
        return repository.save(produto);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        repository.deleteById(id);
    }

    // Entrada de estoque
    @Transactional
    public Produto entradaEstoque(Long id, Integer quantidade) {
        Produto produto = buscarPorId(id);
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        return repository.save(produto);
    }

    // Saída de estoque
    @Transactional
    public Produto saidaEstoque(Long id, Integer quantidade) {
        Produto produto = buscarPorId(id);
        if (produto.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente. Disponível: " + produto.getQuantidade());
        }
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        return repository.save(produto);
    }
}
