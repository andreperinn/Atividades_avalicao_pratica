package br.edu.exemplo;

public class Carrinho {

    private double total;

    public void adicionarProduto(Produto produto) {
        total += produto.getPreco();
    }

    public double getTotal() {
        return total;
    }
}
