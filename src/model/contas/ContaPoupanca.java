package model.contas;

import model.ContaBancaria;

public class ContaPoupanca extends ContaBancaria {

    private double limite;
    public ContaPoupanca(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }
    @Override
    public double sacar(double valor) {
       if(this.getSaldo() - valor < 0){
           if((this.getSaldo() + limite) - valor > 0){
               this.setSaldo(0);
               return valor;
           }
           else {
               return 0;
           }
       }
       else{
           this.setSaldo(this.getSaldo() - valor);
           return valor;
       }
    }
    @Override
    public double depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        return this.getSaldo();
    }
}
