package br.edu.exemplo;

public class Produto {

    private String nome;
    private int quantidade;

    public Produto(String nome) {
        this.nome = nome;
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        if (!quantidadePositiva(quantidade)) {
            return;
        }
        this.quantidade += quantidade;
    }

    public void retirarEstoque(int quantidade) {
        if (!quantidadePositiva(quantidade) || quantidade > this.quantidade) {
            return;
        }
        this.quantidade -= quantidade;
    }

    private boolean quantidadePositiva(int quantidade) {
        return quantidade > 0;
    }
}
