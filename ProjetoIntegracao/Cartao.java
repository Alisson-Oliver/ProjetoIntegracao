public class Cartao {
    
    private int id;
    private String tipoDoCartao;
    private double valorPassagemInteira = 5.20;
    private double saldoNoCartao;


    boolean statusValido;
    boolean statusBloqueio;

    public Cartao(int id, String tipoDoCartao){

        this.id = id;
        this.tipoDoCartao = tipoDoCartao;
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
        this.statusBloqueio = statusBloqueio;
    }

    public void setStatusValido(boolean statusValido) {
        this.statusValido = statusValido;
    }

    public void setValorPassagemInteira(double valorPassagemInteira) {
        this.valorPassagemInteira = valorPassagemInteira;
    }

    public void recargaCartao(double valor){

        this.saldoNoCartao += valor;
        System.out.println("Seu cartão foi recarregado!");
        System.out.println("Saldo atual: " + saldoNoCartao);

    }
}
