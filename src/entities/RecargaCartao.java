package entities;

import java.util.Scanner;
import java.util.ArrayList;

public class RecargaCartao{
    public static void recargaCartao(Scanner entrada, ArrayList<Usuario> usuarios){

        System.out.print("\033[H\033[2J");
        System.out.println(" ============= Recarregar Cartão =============");
        System.out.println();
        System.out.println("Digite o CPF do Titular: ");
        entrada.nextLine();
        String cpfDoTitular = entrada.nextLine();
        System.out.print("\033[H\033[2J");

        boolean cartaoEncontrado = false;
        
        //Verificar se o CPF está cadastrado para prosseguir.
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpfDoTitular)){
            
                //Mostrar os cartões que existem para fazer a recarga.
                for(int index = 0; index < usuarios.get(i).getQuantidadeCartoes(); index++){
                    if (usuarios.get(i).getCartao(index) != null) {
                        System.out.println("[" + (index + 1) + "]" + " ID do cartão: " + usuarios.get(i).getCartao(index) .getId());
                        System.out.println("Tipo do cartão: " + usuarios.get(i).getCartao(index) .getTipoDoCartaoDescricao());
                        System.out.println();
                        cartaoEncontrado = true;
                    }
                }

                //Se os cartões forem encontrados, selecionar o cartão e digitar o valor para a recarga.
                if (cartaoEncontrado) {
                    System.out.println("Digite o cartão que deseja recarregar: ");
                    int cartaoParaRecarga = entrada.nextInt();
                    System.out.println("");

                    System.out.println("Digite o valor: ");
                    int valorAdicionado = entrada.nextInt();
                    System.out.println();
                    System.out.print("\033[H\033[2J");

                    usuarios.get(i).getCartao(cartaoParaRecarga - 1).recargaCartao(valorAdicionado);
                    System.out.println();
                    System.out.println("Pressione ENTER para continuar. ");
                    entrada.nextLine();
                    entrada.nextLine();
                }
            }
        }
                
        //Se não encontrar nenhum cartão, exibir a mensagem.
        if(!cartaoEncontrado){
            System.out.println("Nenhum cartão foi encontrado!");
        }
    }
}