package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo");
        }
        produtos.add(produto);
    }

    public void removerProduto(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nome)) {
                produtos.remove(i);
                return;
            }
        }
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Produto produto : produtos) {
            subtotal += produto.getPreco();
        }
        return subtotal;
    }

    public double getDesconto() {
        if (getSubtotal() >= 500.00) {
            return getSubtotal() * 0.10;
        }
        return 0;
    }

    public double getTotal() {
        return getSubtotal() - getDesconto();
    }
}
