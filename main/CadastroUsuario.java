import java.util.ArrayList;
import java.util.Scanner;


public class CadastroUsuario {
    public static void cadastroUsuario(Scanner entrada, ArrayList<Usuario> usuarios){

    System.out.println();
    entrada.nextLine();

    System.out.print("\033[H\033[2J"); //Limpar

    System.out.println("========== Cadastrar Usuário ==========");
    
    System.out.println("Digite o nome completo: ");
    String nomeDigitado = entrada.nextLine().trim();

    if(nomeDigitado.isEmpty()){
        System.out.println("O campo não pode estar vazio");
        return;
    }


    boolean cpfValido = false;
    String cpfDigitado = "";

    while(!cpfValido){
        
        System.out.println("Digite o CPF do titular: ");
        cpfDigitado = entrada.nextLine().trim();
        String cpfFormatado = formatarCPF(cpfDigitado);

        if(cpfFormatado != null){
            cpfValido = true;
            cpfDigitado = cpfFormatado;
        } else {
            System.out.println("Digite um CPF válido!");
        }

    }

    System.out.println("Digite a data de nascimento (dd/mm/aaaa): ");
    String nascimentoDigitada = entrada.nextLine().trim();

    if(nascimentoDigitada.isEmpty()){
        System.out.println("O campo não pode estar vazio");
        return;
    }

    System.out.println("=======================================");
    System.out.println("Usuário Cadastrado com sucesso!");

  


        System.out.println();

        Usuario adicionarUsuario = new Usuario();
        adicionarUsuario.setNome(nomeDigitado);
        adicionarUsuario.setCpf(cpfDigitado);
        adicionarUsuario.setDataDeNascimento(nascimentoDigitada);
        usuarios.add(adicionarUsuario);


    }

    public static String formatarCPF(String cpf){

        //Remover os caracteres sem ser números
        String cpfNumeros = cpf.replaceAll("[^0-9]", "");

        if(cpfNumeros.length() != 11){
            return null;
        }
        //Colocar . e - no cpf
        return cpfNumeros.substring(0, 3) + "." + 
               cpfNumeros.substring(3, 6) + "." + 
               cpfNumeros.substring(6, 9) + "-" + 
               cpfNumeros.substring(9);
    }

    public static void dadosDoUsuario(Scanner entrada, ArrayList<Usuario> usuarios){

        entrada.nextLine();
        System.out.println("Digite o CPF:");
        String digitado = entrada.nextLine();
        boolean encontrado = false;

        for(int index = 0; index < usuarios.size(); index++){

            if(usuarios.get(index).getCpf().equals(digitado)){

                        System.out.print("\033[H\033[2J");
                        System.out.println("========== DADOS ENCONTRADOS! ==========");
                        System.out.println("Nome do titular: " + usuarios.get(index).getNome());
                        System.out.println("CPF do TItular: " + usuarios.get(index).getCpf());
                        System.out.println("Data de nascimento: " + usuarios.get(index).getDataDeNascimento());
                        System.out.println("Quantidade de cartões: " + usuarios.get(index).getQuantidadeCartoes());
                        System.out.println("==========================================");
                        System.out.println();
                        System.out.println("Clique ENTER para continuar.");
                        entrada.nextLine();
                        encontrado = true;
                        
                        break;
                       
            }  
        }

        if(!encontrado){
                System.out.print("\033[H\033[2J");
                System.out.println("O CPF " + digitado  + " não foi encontrado!");
                System.out.println("Clique ENTER para continuar.");
                entrada.nextLine();
            }

       

    }


}
