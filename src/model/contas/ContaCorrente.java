package model.contas;

import model.ContaBancaria;

public class ContaCorrente extends ContaBancaria {
    private double taxaDeOperacao;

    public ContaCorrente(double saldo) {
        super(saldo);

    }
    @Override
    public double sacar(double valor) {
        return 0;
    }

    @Override
    public double depositar(double valor) {
        return 0;
    }
}
