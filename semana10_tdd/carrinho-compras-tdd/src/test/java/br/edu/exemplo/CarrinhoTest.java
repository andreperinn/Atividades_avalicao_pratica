package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Testes escritos antes da implementação, um requisito por vez,
 * seguindo a sequência de REQUISITOS.md (RED -> GREEN -> REFACTOR).
 */
class CarrinhoTest {

    private static final double DELTA = 0.001;

    // Requisito 1 — Carrinho vazio
    @Test
    void carrinhoVazioDeveTerTotalZero() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 2 — Adicionar um produto
    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(new Produto("Teclado", 100.00));

        assertEquals(100.00, carrinho.getTotal(), DELTA);
    }

    // Requisito 3 — Adicionar vários produtos
    @Test
    void deveSomarOsPrecosDeVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(new Produto("Teclado", 100.00));
        carrinho.adicionarProduto(new Produto("Mouse", 50.00));

        assertEquals(150.00, carrinho.getTotal(), DELTA);
    }

    // Requisito 4 — Remover produto
    @Test
    void deveRemoverProdutoDoCarrinho() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Teclado", 100.00));
        carrinho.adicionarProduto(new Produto("Mouse", 50.00));

        carrinho.removerProduto("Mouse");

        assertEquals(100.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void removerProdutoQueNaoEstaNoCarrinhoNaoDeveAlterarOTotal() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Teclado", 100.00));

        carrinho.removerProduto("Monitor");

        assertEquals(100.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveRemoverApenasUmaUnidadeQuandoHaProdutosRepetidos() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Mouse", 50.00));
        carrinho.adicionarProduto(new Produto("Mouse", 50.00));
        carrinho.adicionarProduto(new Produto("Teclado", 100.00));

        carrinho.removerProduto("Mouse");

        assertEquals(150.00, carrinho.getTotal(), DELTA);
    }
}
