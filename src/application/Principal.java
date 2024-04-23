package application;

import java.util.ArrayList;
import java.util.Scanner;
import entities.*;
import entities.enums.TipoCartao;

public class Principal {
    public static void main(String[] args) {
     
    final int CADASTROUSUARIO = 1;
    final int DADOSUSUARIO = 2;
    final int CADASTROCARTAO = 3;
    final int DADOSCARTAO = 4;
    final int RECARREGARCARTAO = 5;
    final int BLOQUEAROUDESBLOQUEAR = 6;
    final int UTILIZARTRANSPORTE = 7;
    final int SAIR = 8;

    Scanner entrada = new Scanner(System.in);
    ArrayList<Usuario> usuarios = new ArrayList<>(); 

    Usuario userteste = new Usuario();
    
    userteste.setNome("Alisson Alves");
    userteste.setCpf("11122233344");
    userteste.setDataDeNascimento("14/01/2005");

    Cartao cartao = new Cartao(12873, TipoCartao.MEIA_PASSAGEM_ESTUDANTIL);
    userteste.setCartao(cartao, 0);

    usuarios.add(userteste);
   

    boolean running = true;


    do { 

    System.out.println("========== Integração - Transporte Público ==========");
    System.out.printf("[%d] Cadastrar Usuário %n", CADASTROUSUARIO);
    System.out.printf("[%d] Consultar informações do usuário %n", DADOSUSUARIO);
    System.out.printf("[%d] Cadastrar cartão %n", CADASTROCARTAO);
    System.out.printf("[%d] Consultar informações do cartão %n", DADOSCARTAO);
    System.out.printf("[%d] Recarga cartão %n", RECARREGARCARTAO);
    System.out.printf("[%d] Bloquear/Desbloquear cartão %n", BLOQUEAROUDESBLOQUEAR);
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

            CadastroCartao.cadastrarCartao(entrada, usuarios);
            break;

        case RECARREGARCARTAO:

            RecargaCartao.recargaCartao(entrada, usuarios);
            break;

        case DADOSCARTAO:

            BuscarCartao.buscarCartao(entrada, usuarios);
            break;

        case BLOQUEAROUDESBLOQUEAR:

            BloquearOuDesbloquear.bloquearOuDesbloquear(entrada, usuarios);
            break;

        case UTILIZARTRANSPORTE:

            break;

        case SAIR:

            System.out.println();
            System.out.println("Obrigado por utilizar o nosso serviço!");
            System.out.println("[1] Muito Pessímo ");
            System.out.println("[2] Pessímo");
            System.out.println("[3] Bom");
            System.out.println("[4] Ótimo");
            System.out.println("[5] Excelente ");
            System.out.println();
            System.out.println("Avalie o nosso serviço: ");
            entrada.nextLine();
            entrada.nextLine();

            running = false;
            break;

        default:

            System.out.println("ERRO! Digite uma opção VÁLIDA!");
            break;
    }

    } while (running);

    }
}
