package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static final double VALOR_MINIMO_PARA_DESCONTO = 500.00;
    private static final double PERCENTUAL_DE_DESCONTO = 0.10;

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
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

    public double getDesconto() {
        double subtotal = getSubtotal();
        if (subtotal >= VALOR_MINIMO_PARA_DESCONTO) {
            return subtotal * PERCENTUAL_DE_DESCONTO;
        }
        return 0;
    }

    public double getTotal() {
        return getSubtotal() - getDesconto();
    }
}
