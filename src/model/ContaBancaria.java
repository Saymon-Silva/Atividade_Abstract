package model;

import java.util.ArrayList;

public abstract class ContaBancaria implements IImprimivel{
    private int numeroConta;
    private double saldo;
    public ContaBancaria(double saldo){
        this.saldo = saldo;
    }
    public abstract double sacar(double valor);
    public abstract double depositar(double valor);
    public boolean transferir(ContaBancaria contaTransferidor, double valor, ContaBancaria contaTransferir){
        if(contaTransferidor.sacar(valor) >= 0){
            contaTransferir.depositar(valor);
            return true;
        }
      return false;
    }
    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
}
