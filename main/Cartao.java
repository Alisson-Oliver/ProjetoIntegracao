public class Cartao {
    
    private String tipoDoCartao; 
    private int id;
    private double valorPassagemInteira = 5.20;
    private double saldoNoCartao;

    boolean statusValido;
    boolean statusBloqueado;


    public Cartao(int id, String tipoDoCartao){

        this.id = id;
        this.tipoDoCartao = tipoDoCartao;
        this.statusBloqueado = true;
        this.statusValido = true; 

    }

    public int getId() {
        return id;
    }

    public double getSaldoNoCartao() {
        return saldoNoCartao;
    }
    public String getTipoDoCartao() {
        return tipoDoCartao;
    }

    public double getValorPassagemInteira() {
        return valorPassagemInteira;
    }

    public void setSaldoNoCartao(double saldoNoCartao) {
        this.saldoNoCartao = saldoNoCartao;
    }

    public void setStatusBloqueio(boolean statusBloqueio) {
        this.statusBloqueado = statusBloqueio;
    }

    public void setStatusValido(boolean statusValido) {
        this.statusValido = statusValido;
    }

    public void setValorPassagemInteira(double valorPassagemInteira) {
        this.valorPassagemInteira = valorPassagemInteira;
    }

    public void recargaCartao(double valor){

        this.saldoNoCartao += valor;
        System.out.println("==============================");
        System.out.println("Seu cartão foi recarregado!");
        System.out.printf("Saldo atual: R$ %.2f%n",saldoNoCartao);
        System.out.println("==============================");
       


    }

    
   
}
