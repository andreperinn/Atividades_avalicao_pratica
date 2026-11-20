package br.edu.exemplo;

public class BubbleSort {

    private int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        for (int passada = 0; passada < numeros.length - 1; passada++) {
            boolean houveTroca = false;

            // a cada passada, o maior valor restante já foi para o final do vetor
            for (int j = 0; j < numeros.length - 1 - passada; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    trocar(j, j + 1);
                    houveTroca = true;
                }
            }

            // se nenhuma troca aconteceu, o vetor já está ordenado
            if (!houveTroca) {
                return;
            }
        }
    }

    private void trocar(int i, int j) {
        int auxiliar = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = auxiliar;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
