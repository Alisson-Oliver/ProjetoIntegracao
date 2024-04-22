public class Usuario {
    
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private int quantidadeCartoes;
    public Cartao[] cartoes = new Cartao[2] ;

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeCartoes() {
        return quantidadeCartoes;
    }

    public void addQuantidade(){

        this.quantidadeCartoes++;

    }
}
