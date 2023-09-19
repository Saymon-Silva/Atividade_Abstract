package model;

import java.util.ArrayList;

public abstract class ContaBancaria implements IImprimivel<ContaBancaria, Integer>{
    private int numeroConta;
    private double saldo;

    public static ArrayList<ContaBancaria> todasContasBancarias = new ArrayList<>();

    public ContaBancaria(double saldo){
        this.saldo = saldo;
        this.numeroConta = todasContasBancarias.size() + 1;
        todasContasBancarias.add(this);
    }
    public abstract double sacar(double valor);
    public abstract double depositar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
