package model.contas;

import model.ContaBancaria;
import model.IImprimivel;

public class ContaCorrente extends ContaBancaria{
    private final double taxaDeOperacao;

    public ContaCorrente(double saldo) {
        super(saldo);
        this.taxaDeOperacao = 0.5;
    }
    @Override
    public double sacar(double valor) {
        if(this.getSaldo() - (valor + ((valor * this.taxaDeOperacao) / 100 )) >= 0){
            this.setSaldo(this.getSaldo() - (valor + ((valor * this.taxaDeOperacao) / 100 )));
            return valor;
        }
        else{
            return (this.getSaldo() - (valor + ((valor * this.taxaDeOperacao) / 100 )));
        }
    }
    @Override
    public double depositar(double valor) {
        this.setSaldo(this.getSaldo() + (valor - (valor * this.taxaDeOperacao)));
        return this.getSaldo();
    }

    public String mostrarDados() {
        return  "\n    CONTA CORRENTE" +
                "\nNumero: " + getNumeroConta() +
                "\nSaldo: " + getSaldo() +
                "\ntaxa de operação: " + taxaDeOperacao;
    }
}
