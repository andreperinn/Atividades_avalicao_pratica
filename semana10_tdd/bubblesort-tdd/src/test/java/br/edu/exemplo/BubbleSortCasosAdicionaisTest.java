package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Casos de teste adicionais (situações de borda), mantendo intactos
 * os testes fornecidos em BubbleSortTest.
 */
class BubbleSortCasosAdicionaisTest {

    @Test
    void deveOrdenarVetorEmOrdemDecrescente() {
        BubbleSort bubbleSort =
                new BubbleSort(new int[]{5, 4, 3, 2, 1});

        bubbleSort.ordenar();

        assertArrayEquals(
                new int[]{1, 2, 3, 4, 5},
                bubbleSort.getNumeros()
        );
    }

    @Test
    void deveOrdenarVetorComNumerosNegativosEZero() {
        BubbleSort bubbleSort =
                new BubbleSort(new int[]{3, -1, 0, -5, 2});

        bubbleSort.ordenar();

        assertArrayEquals(
                new int[]{-5, -1, 0, 2, 3},
                bubbleSort.getNumeros()
        );
    }

    @Test
    void deveManterVetorVazio() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{}, bubbleSort.getNumeros());
    }

    @Test
    void deveManterVetorComUmElemento() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{7});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{7}, bubbleSort.getNumeros());
    }

    @Test
    void naoDeveAceitarVetorNulo() {
        assertThrows(IllegalArgumentException.class, () -> new BubbleSort(null));
    }
}
