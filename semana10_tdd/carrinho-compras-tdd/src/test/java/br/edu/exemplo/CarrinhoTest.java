package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Requisito 5 — Produto com preço inválido
    // Decisão: preço negativo lança IllegalArgumentException e o carrinho não é alterado.
    @Test
    void naoDeveAdicionarProdutoComPrecoNegativo() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Mouse", 50.00));

        assertThrows(IllegalArgumentException.class,
                () -> carrinho.adicionarProduto(new Produto("Teclado", -100.00)));

        assertEquals(50.00, carrinho.getTotal(), DELTA);
    }

    @Test
    void deveAceitarProdutoComPrecoZero() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(new Produto("Brinde", 0.00));

        assertEquals(0.00, carrinho.getTotal(), DELTA);
    }

    // Requisito 6 — Desconto de 10% para compras a partir de R$ 500,00
    @Test
    void compraDe600DeveTerDescontoDe10PorCento() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Monitor", 400.00));
        carrinho.adicionarProduto(new Produto("Teclado", 200.00));

        assertEquals(600.00, carrinho.getSubtotal(), DELTA);
        assertEquals(60.00, carrinho.getDesconto(), DELTA);
        assertEquals(540.00, carrinho.getTotal(), DELTA);
    }

    @ParameterizedTest(name = "subtotal {0} -> desconto {1}, total {2}")
    @CsvSource({
            "499.99, 0.00, 499.99",
            "500.00, 50.00, 450.00",
            "500.01, 50.001, 450.009"
    })
    void deveAplicarDescontoSomenteAPartirDe500(double preco, double descontoEsperado, double totalEsperado) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(new Produto("Produto", preco));

        assertEquals(preco, carrinho.getSubtotal(), DELTA);
        assertEquals(descontoEsperado, carrinho.getDesconto(), DELTA);
        assertEquals(totalEsperado, carrinho.getTotal(), DELTA);
    }
}
