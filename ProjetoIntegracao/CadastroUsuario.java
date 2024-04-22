import java.util.ArrayList;
import java.util.Scanner;


public class CadastroUsuario {
    public static void cadastroUsuario(Scanner entrada, ArrayList<Usuario> usuarios){


    System.out.println();
    System.out.println();
    System.out.println();

    entrada.nextLine();
    System.out.println("####### Cadastrar Usuário #######");
    
    System.out.println("Digite o nome completo: ");
    String nomeDigitado = entrada.nextLine().trim();

    if(nomeDigitado.isEmpty()){
        System.out.println("O campo não pode estar vazio");
        return;
    }


    System.out.println("Digite o CPF do titular: ");
    String cpfDigitado = entrada.nextLine().trim();

    if(cpfDigitado.length() != 11){
        System.out.println("CPF INVÁLIDO!");
        return;
    }
    
    if(cpfDigitado.isEmpty()){
        System.out.println("O campo não pode estar vazio");
        return;
    }

    System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
    String nascimentoDigitada = entrada.nextLine().trim();
    if(nascimentoDigitada.isEmpty()){
        System.out.println("O campo não pode estar vazio");
        return;
    }

    System.out.println("#################################");
    
    System.out.println();
    System.out.println();
    System.out.println();
    
    Usuario adicionarUsuario = new Usuario();
    adicionarUsuario.setNome(nomeDigitado);
    adicionarUsuario.setCpf(cpfDigitado);
    adicionarUsuario.setDataDeNascimento(nascimentoDigitada);
    usuarios.add(adicionarUsuario);




    }
}
