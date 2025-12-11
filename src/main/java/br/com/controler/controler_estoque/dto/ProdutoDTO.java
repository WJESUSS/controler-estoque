package br.com.controler.controler_estoque.dto;


import jakarta.validation.constraints.*;

public record ProdutoDTO(
        Long id,

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotNull @DecimalMin("0.01")
        Double preco,

        @NotNull @Min(0)
        Integer quantidade,

        String descricao
) {}