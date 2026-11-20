package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Casos de teste adicionais, mantendo intactos os testes fornecidos em ContaBancariaTest.
 * Operações inválidas são ignoradas, no mesmo padrão do teste naoDevePermitirSaqueMaiorQueSaldo.
 */
class ContaBancariaCasosAdicionaisTest {

    @Test
    void naoDeveDepositarValorNegativo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.depositar(-50);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveDepositarValorZero() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(0);
        assertEquals(0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveSacarValorNegativo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(-30);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveSacarValorZero() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(0);
        assertEquals(100, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSacarTodoOSaldo() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100);
        conta.sacar(100);
        assertEquals(0, conta.getSaldo(), 0.001);
    }
}
