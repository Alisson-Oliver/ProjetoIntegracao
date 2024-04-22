import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
     
    final int CADASTROUSUARIO = 1;
    final int DADOSUSUARIO = 2;
    final int CADASTROCARTAO = 3;
    final int RECARREGARCARTAO = 4;
    final int BUSCARCARTAO = 5;
    final int BLOCKUNBLOCK = 6;
    final int UTILIZARTRANSPORTE = 7;
    final int SAIR = 8;

    Scanner entrada = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Integer> idsCadastrados = new ArrayList<>();

    Usuario user1 = new Usuario();
    user1.nome = "Ana Souza";
    user1.cpf = "333.444.555-66";
    user1.dataDeNascimento = "10/07/2005";
    Cartao cartao = new Cartao(31324, "Meia Estudantil");
    user1.cartoes[0] = cartao;
    Cartao cartao2 = new Cartao(31554, "Meia Estudantil");
    user1.cartoes[1] = cartao2;
    usuarios.add(user1);
    user1.addQuantidade();
    user1.addQuantidade();

    

    Usuario user2 = new Usuario();
    user2.nome = "Maria Silva";
    user2.cpf = "555.666.777-88";
    user2.dataDeNascimento = "05/09/1990";
    usuarios.add(user2);

    Usuario user3 = new Usuario();
    user3.nome = "João Oliveira";
    user3.cpf = "999.888.777-66";
    user3.dataDeNascimento = "21/03/1985";
    usuarios.add(user3);


    boolean running = true;


    do { 

    System.out.println("========== Integração - Transporte Público ==========");
    System.out.printf("[%d] Cadastrar Usuário %n", CADASTROUSUARIO);
    System.out.printf("[%d] Informações do usuário %n", DADOSUSUARIO);
    System.out.printf("[%d] Cadastrar cartão %n", CADASTROCARTAO);
    System.out.printf("[%d] Recarga cartão %n", RECARREGARCARTAO);
    System.out.printf("[%d] Buscar cartão %n", BUSCARCARTAO);
    System.out.printf("[%d] Bloquear/Desbloquear cartão %n", BLOCKUNBLOCK);
    System.out.printf("[%d] Utilizar Transporte %n", UTILIZARTRANSPORTE);
    System.out.printf("[%d] Sair %n", SAIR);
    System.out.println("=====================================================");


    
    System.out.println("Digite uma opção: ");
    int opcao = entrada.nextInt();
    
    switch (opcao) {
        case CADASTROUSUARIO:
            
            CadastroUsuario.cadastroUsuario(entrada, usuarios);
            break;

        case DADOSUSUARIO:

            CadastroUsuario.dadosDoUsuario(entrada, usuarios);
            break;
    
        case CADASTROCARTAO:

            CadastroCartao.cadastrarCartao(entrada, usuarios, idsCadastrados);
            break;

        case RECARREGARCARTAO:

        
            break;

        case BUSCARCARTAO:

            break;

        case BLOCKUNBLOCK:

            break;

        case UTILIZARTRANSPORTE:

            break;

        case SAIR:

            System.out.println();
            System.out.println("Obrigado por utilizar o nosso serviço!");
            running = false;
            break;

        default:

            System.out.println("ERRO! Digite uma opção VÁLIDA!");
            break;
    }

    } while (running);


    }
}
