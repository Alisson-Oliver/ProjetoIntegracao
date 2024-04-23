package entities;

import java.util.Scanner;
import java.util.ArrayList;

public class BuscarCartao {

    public static void buscarCartao(Scanner entrada, ArrayList<Usuario> usuarios){

        System.out.print("\033[H\033[2J");
        System.out.println("=============== Buscar Cartão ===============");
        System.out.println();
        System.out.println("Digite o CPF do Titular: ");
        entrada.nextLine();
        String cpfParaPesquisa = entrada.nextLine();
        System.out.print("\033[H\033[2J");


        boolean cartoesEncontrados = false;

        for(int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getCpf().equals(cpfParaPesquisa)) {
                for(int index = 0; index < usuarios.get(i).getNumerosCartoes(); index++){
                    if (usuarios.get(i).getCartao(index) != null) {

                        System.out.println();
                        System.out.println("Id do cartão: " + usuarios.get(i).getCartao(index).getId());
                        System.out.println("Tipo do cartão: " + usuarios.get(i).getCartao(index).getTipoDoCartaoDescricao());
                        System.out.println("Saldo atual: R$" + usuarios.get(i).getCartao(index).getSaldoNoCartao());
                        cartoesEncontrados = true;
                    }

                }

            }
        }
        if (!cartoesEncontrados) {
            System.out.println("Nenhum Cartão encontrado para esse CPF!");
        }
        System.out.println("=============================================");

    }
}