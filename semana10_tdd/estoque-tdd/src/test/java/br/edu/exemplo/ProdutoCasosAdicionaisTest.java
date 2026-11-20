package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Casos de teste adicionais, mantendo intactos os testes fornecidos em ProdutoTest.
 */
class ProdutoCasosAdicionaisTest {

    @Test
    void produtoDeveGuardarONome() {
        Produto produto = new Produto("Teclado");

        assertEquals("Teclado", produto.getNome());
    }

    @Test
    void naoDeveAdicionarQuantidadeZero() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(0);

        assertEquals(0, produto.getQuantidade());
    }

    @Test
    void deveRetirarTodoOEstoque() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(10);

        assertEquals(0, produto.getQuantidade());
    }

    @Test
    void naoDeveRetirarQuantidadeNegativa() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(-5);

        assertEquals(10, produto.getQuantidade());
    }

    @Test
    void naoDeveRetirarQuantidadeZero() {
        Produto produto = new Produto("Teclado");

        produto.adicionarEstoque(10);
        produto.retirarEstoque(0);

        assertEquals(10, produto.getQuantidade());
    }
}
