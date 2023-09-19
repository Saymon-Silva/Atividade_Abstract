package model;

import java.sql.Array;
import java.util.ArrayList;

public class Banco implements IImprimivel{

    public static ContaBancaria contaBancaria;
    public static ArrayList<ContaBancaria> todasContasBancarias = new ArrayList<>();

    public ContaBancaria criarConta(ContaBancaria conta){
        conta.setNumeroConta(todasContasBancarias.size() + 1);
        todasContasBancarias.add(conta);
        return conta;
    }
    public void removerConta(ContaBancaria conta){
        todasContasBancarias.remove(conta);
    }
    public ContaBancaria procurarConta(int codigo){
        for (ContaBancaria contaFor : todasContasBancarias){
            if(contaFor.getNumeroConta() == codigo){
                return contaFor;
            }
        }
        return null;
    }

    @Override
    public String mostrarDados() {
        String dados = " ";
        for(ContaBancaria contaFor : todasContasBancarias){
            dados += contaFor.mostrarDados();
        }
        return dados;
    }
}
