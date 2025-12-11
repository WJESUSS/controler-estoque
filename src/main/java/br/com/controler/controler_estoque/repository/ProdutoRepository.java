package br.com.controler.controler_estoque.repository;


import br.com.controler.controler_estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}