package br.edu.exemplo;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (!valorPositivo(valor)) {
            return;
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (!valorPositivo(valor) || valor > saldo) {
            return;
        }
        saldo -= valor;
    }

    private boolean valorPositivo(double valor) {
        return valor > 0;
    }
}
