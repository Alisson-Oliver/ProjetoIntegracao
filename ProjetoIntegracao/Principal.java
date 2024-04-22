import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
     
    final int CADASTROUSUARIO = 1;
    final int CADASTROCARTAO = 2;
    final int RECARREGARCARTAO = 3;
    final int BUSCARCARTAO = 4;
    final int BLOCKUNBLOCK = 5;
    final int UTILIZARTRANSPORTE = 6;
    final int SAIR = 7;

    Scanner entrada = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Integer> idsCadastrados = new ArrayList<>();


    boolean running = true;

    do { 
        
    System.out.println("########## Integração - Transporte Público ##########");
    System.out.printf("[%d] Cadastrar Usuário %n", CADASTROUSUARIO);
    System.out.printf("[%d] Cadastrar cartão %n", CADASTROCARTAO);
    System.out.printf("[%d] Recarga cartão %n", RECARREGARCARTAO);
   
    System.out.printf("[%d] Buscar cartão %n", BUSCARCARTAO);
    System.out.printf("[%d] Bloquear/Desbloquear cartão %n", BLOCKUNBLOCK);
    System.out.printf("[%d] Utilizar Transporte %n", UTILIZARTRANSPORTE);
    System.out.printf("[%d] Sair %n", SAIR);
    System.out.println("#####################################################");

    System.out.println();
    System.out.println("Digite uma opção: ");
    int opcao = entrada.nextInt();
    
    switch (opcao) {
        case CADASTROUSUARIO:
            
            CadastroUsuario.cadastroUsuario(entrada, usuarios);
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
