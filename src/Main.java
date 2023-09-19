import model.Banco;
import model.ContaBancaria;
import model.Relatorio;
import model.contas.ContaCorrente;
import model.contas.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner scfs = new Scanner(System.in);
    public static Banco banco;
    public static ContaBancaria conta;
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;
        do {
            System.out.print("""
                    MENU
                    0 - Sair
                    1 - Cadastrar Conta
                    2 - Procurar Conta
                    3 - Remover Conta
                    4 - Gerar Relatorio das Contas
                    Escolha : """);
            opcao = sc.nextInt();
            switch (opcao){
                case 0 -> System.out.println("Adeus!");
                case 1 -> cadastrarConta();
                case 2 -> selecionarConta();
                case 3 -> removerConta();
                case 4 -> gerarRelatorio();
                default -> System.out.println("Insira valores validos!");
            }
        }while(opcao != 0);
    }
    public static void cadastrarConta() {
        int opcao;
        do {
            System.out.print("""
                    0 - Voltar
                    1 - Poupança
                    2 - Corrente
                    escolha : """);
            opcao = sc.nextInt();
            if(opcao == 0){
                return;
            }
            System.out.print("Insira o saldo presente na conta : ");
            double saldo = sc.nextDouble();
            switch (opcao){
                case 1 -> {
                    System.out.print("Insira o limite da sua conta : ");
                    double limite = sc.nextDouble();
                    ContaBancaria conta = new ContaPoupanca(saldo,limite);
                    banco.criarConta(conta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println(conta.mostrarDados());
                }
                case 2 -> {
                   ContaBancaria conta = new ContaCorrente(saldo);
                   banco.criarConta(conta);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println(conta.mostrarDados());
                }
                default -> System.out.println("Insira valores validos!");
            }
        }while(opcao != 1 || opcao != 2);
    }
    //region(selecionar conta)
    public static void selecionarConta(){

            System.out.print("Insira o numero da conta para pesquisa : ");
            int numeroConta = sc.nextInt();
            if (banco.procurarConta(numeroConta) != null) {
                conta = banco.procurarConta(numeroConta);
                menuSelecionarConta();
            } else {
                System.out.println("Nenhuma conta cadastrada com esse numero!");
            }
    }
    public static void menuSelecionarConta(){
        int opcao;
        System.out.print("""
                MENU
                0 - Voltar
                1 - Depositar
                2 - Sacar
                3 - Transferir
                4 - Gerar Relatorio
                escolha : """);
        opcao = sc.nextInt();
        switch(opcao){
            case 0 ->{}
            case 1 -> depositar();
            case 2 -> sacar();
            case 3 -> tranferir();
            case 4 -> gerarRelatorioContaSelecionada();
            default -> System.out.println("Insira valores validos!");
        }
    }
    public static void depositar(){
        System.out.print("Insira o valor que deseja depositar : ");
        double valor =sc.nextDouble();
        conta.depositar(valor);
        System.out.println("Deposito efetuado!");
    }
    public static void sacar(){
        System.out.print("Insira o valor que deseja sacar : ");
        double valor = sc.nextDouble();
        if(conta.sacar(valor) >= 0){
            System.out.println("Saque efetuado!");
            System.out.println("Saldo restante : " + conta.getSaldo());
        }
        else{
            System.out.println("Saque não efetuado!");
            System.out.println("Saldo insuficiente!");
        }
    }
    public static void tranferir(){
        System.out.print("Insira o numero da conta que você deseja fazer a transferencia : ");
        int numeroContaTransferencia = sc.nextInt();
        if(banco.procurarConta(numeroContaTransferencia) != null){
            ContaBancaria contaTransferir = banco.procurarConta(numeroContaTransferencia);
            System.out.print("Insira o valor que você deseja transferir : ");
            double valor = sc.nextDouble();
            if(conta.transferir(conta,valor,contaTransferir)){
                System.out.println("Transação bem sucedida!");
            }
            else{
                System.out.println("Transação não efetuada!");
                System.out.println("Saldo insuficiente!");
            }
        }
        else{
            System.out.println("Nenhuma conta cadastrada com esse numero!");
        }
    }
    public static void gerarRelatorioContaSelecionada(){
        System.out.println(conta.mostrarDados());
    }
    //endregion

    public static void removerConta(){
            System.out.print("Insira o numero da conta para remoção : ");
            int numeroConta = sc.nextInt();
            if (banco.procurarConta(numeroConta) != null) {
                banco.removerConta(banco.procurarConta(numeroConta));
                System.out.println("Conta removida com sucesso!");
            } else {
                System.out.println("Nenhuma conta cadastrada com esse numero!");
            }
    }
    public static void gerarRelatorio(){
        System.out.println(banco.mostrarDados());
    }
}