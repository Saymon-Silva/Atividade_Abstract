package model;

public class Relatorio{

    public String gerarRelatorio(IImprimivel objeto){
        return objeto.mostrarDados();
    }
}
