package model.contas;

import model.ContaBancaria;
import model.IImprimivel;

public class ContaCorrente extends ContaBancaria{
    private double taxaDeOperacao;

    public ContaCorrente(double saldo) {
        super(saldo);

    }
    @Override
    public double sacar(double valor) {
        if(this.getSaldo() - (valor + (valor * this.taxaDeOperacao)) > 0){
            return valor;
        }
        else{
            return 0;
        }
    }
    @Override
    public double depositar(double valor) {
        this.setSaldo(this.getSaldo() + (valor - (valor * this.taxaDeOperacao)));
        return this.getSaldo();
    }

    @Override
    public ContaBancaria mostrarDados(Integer codigo) {
        for(ContaBancaria contaFor : todasContasBancarias){
            if(codigo == contaFor.getNumeroConta()){
                ContaBancaria contaCorrente = new ContaCorrente(contaFor.getSaldo());
                return contaCorrente;
            }
        }
        return null;
    }
}
