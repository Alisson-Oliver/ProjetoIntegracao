import java.util.Scanner;
import java.util.ArrayList;

public class RecargaCartao{
    public static void recargaCartao(Scanner entrada, ArrayList<Usuario> usuarios){

        System.out.print("\033[H\033[2J");
        System.out.println(" ============= Recarregar Cartão =============");
        System.out.println("");
        System.out.println("Digite o CPF do Titular do cartão: ");
        entrada.nextLine();
        String cpfDoTitular = entrada.nextLine();
        System.out.print("\033[H\033[2J");

        boolean cartaoEncontrado = false;
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpfDoTitular)){
                for(int index = 0; index < usuarios.get(i).cartoes.length; index++){
                    if (usuarios.get(i).cartoes[index] != null) {
                        System.out.println("[" + (index + 1) + "]" + " ID do cartão: " + usuarios.get(i).cartoes[index].getId());
                        System.out.println("Tipo do cartão: " + usuarios.get(i).cartoes[index].getTipoDoCartao());
                        System.out.println();
                        cartaoEncontrado = true;
                    }
                }
            if (cartaoEncontrado) {
                System.out.println("Digite o cartão que deseja recarregar: ");
                int cartaoParaRecarga = entrada.nextInt();
                System.out.println("");
                cartaoParaRecarga -= 1;

                System.out.println("Digite o valor: ");
                int valorAdicionado = entrada.nextInt();
                System.out.println();
                System.out.print("\033[H\033[2J");



                if (cartaoParaRecarga == 0) {

                    usuarios.get(i).cartoes[0].recargaCartao(valorAdicionado);

                    System.out.println();
                    System.out.println("Pressione ENTER para continuar. ");
                    entrada.nextLine();
                    entrada.nextLine();

                    break;
                    
                } else if(cartaoParaRecarga == 1){

                    usuarios.get(i).cartoes[1].recargaCartao(valorAdicionado);

                    System.out.println();
                    System.out.println("Pressione ENTER para continuar. ");
                    entrada.nextLine();
                    entrada.nextLine();

                    break;


                }


                
            }
            }
        }         
        if(!cartaoEncontrado){
            System.out.println("Nenhum cartão foi encontrado!");
        }
    }
}