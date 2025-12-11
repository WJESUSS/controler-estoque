package br.com.controler.controler_estoque.controller;


import br.com.controler.controler_estoque.dto.ProdutoDTO;
import br.com.controler.controler_estoque.model.Produto;
import br.com.controler.controler_estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produto criar(@Valid @RequestBody ProdutoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/entrada")
    public Produto entradaEstoque(@PathVariable Long id, @RequestBody Integer quantidade) {
        return service.entradaEstoque(id, quantidade);
    }

    @PatchMapping("/{id}/saida")
    public Produto saidaEstoque(@PathVariable Long id, @RequestBody Integer quantidade) {
        return service.saidaEstoque(id, quantidade);
    }
}
