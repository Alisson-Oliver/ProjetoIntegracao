public class Usuario {
    
    String nome;
    String cpf;
    String dataDeNascimento;
    int quantidadeCartoes;
    Cartao[] cartoes = new Cartao[2]; 


    public Cartao[] getCartoes() {
        return cartoes;
    }
    
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
