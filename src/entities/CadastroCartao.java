package entities;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import entities.enums.TipoCartao;

public class CadastroCartao {


    public static void cadastrarCartao(Scanner entrada, ArrayList<Usuario> usuarios){

        ArrayList<Integer> idsCadastrados = new ArrayList<>();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horasFormatada = DateTimeFormatter.ofPattern("HH:mm:ss");

        entrada.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.println("========== Cadastrar Cartão ==========");

        System.out.println("Digite o CPF do Titular: ");
        String cpfDigitado = entrada.nextLine();

        //Se o CPF não for encontrado irá mostrar a mensagem
        boolean cpfEncontrado = false;

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpfDigitado)){
                cpfEncontrado = true;

                //ADICIONAR FUNÇÃO PARA PECORRER E VER SE EXISTE PELO MENOS UM LUGAR PARA COLOCAR O CARTAO

                //Verificar se existe dois cartões, se não ele pede o cartão a ser criado
                if(usuarios.get(i).getCartao(0) == null || usuarios.get(i).getCartao(1) == null){

                    //Código para adcionar cartão
                    System.out.println();
                    System.out.println("Qual tipo de cartão deseja cadastrar?");
                    System.out.println("[1] Meia Passagem Estudantil");
                    System.out.println("[2] Bilhete Identificado");
                    System.out.println();
                    System.out.println("Digite a opção: ");

                    int opcaoDigitada = entrada.nextInt();
                    TipoCartao tipoCartaoDigitado = null;

                        // Mudar o Tipo do cartão conforme a seleção.
                        switch (opcaoDigitada){
                            case 1:
                                tipoCartaoDigitado = TipoCartao.MEIA_PASSAGEM_ESTUDANTIL;
                                break;
                            case 2:
                                tipoCartaoDigitado = TipoCartao.BILHETE_IDENTIFICADO;
                                break;
                            default:
                                System.out.println("Digite uma opção válida!");
                                break;
                            }
    
                        //Verificar se o cartão não existe. Se existir retorna o INDEX do cartão
                        Integer cartaoExistente = verificarCartao(usuarios, i, tipoCartaoDigitado);

                        if(cartaoExistente == null){
                                                 
                            //Chamar função para gerar o ID
                            int idGerado = gerarID(idsCadastrados);

                            int indexCartao = 0;

                            //Criar cartão no index que está vazio
                            for(int index = 0; index < usuarios.get(i).getNumerosCartoes(); index++){

                                if(usuarios.get(i).getCartao(index) == null){
                                    usuarios.get(i).setCartao(new Cartao(idGerado, tipoCartaoDigitado), index);
                                    usuarios.get(i).addQuantidade();
                                    indexCartao = index;
                                    break;
                                }

                            } 
                    
                            LocalDate dataHojeISO = LocalDate.now();
                            LocalTime horasISO = LocalTime.now(); 

                            System.out.print("\033[H\033[2J");
                            System.out.println("========== SEU CARTÃO FOI CRIADO! ==========");
                            System.out.println("ID do cartão: " + idGerado);
                            System.out.println("Nome do titular: " + usuarios.get(i).getNome());
                            System.out.println("CPF do TItular: " + usuarios.get(i).getCpf());
                            System.out.println("Data de nascimento: " + usuarios.get(i).getDataDeNascimento());
                            System.out.println();
                            System.out.println("Tipo do cartão: " + usuarios.get(i).getCartao(indexCartao).getTipoDoCartaoDescricao());
                            System.out.println("Cartão criado na data " + dataHojeISO.format(dataFormatada) + " às " + horasISO.format(horasFormatada));
                            System.out.println("=============================================");
                            System.out.println();
                            System.out.println("Clique ENTER para continuar.");
                            entrada.nextLine();
                            entrada.nextLine();
                            System.out.print("\033[H\033[2J");
                            break;
                        

                        } else {

                            System.out.print("\033[H\033[2J");
                            System.out.printf("Você já tem um cartão %s", usuarios.get(i).getCartao(cartaoExistente).getTipoDoCartaoDescricao());
                            System.out.println();
                            System.out.println("ID do cartão: " + usuarios.get(i).getCartao(cartaoExistente).getId());
                            System.out.println("Nome do titular: " + usuarios.get(i).getNome());
                            System.out.println("CPF do TItular: " + usuarios.get(i).getCpf());
                            System.out.println("Data de nascimento: " + usuarios.get(i).getDataDeNascimento());
                            System.out.println();
                            System.out.println("Clique ENTER para continuar.");
                            entrada.nextLine();
                            entrada.nextLine();
                            break;
                        }

                } else{
                    //Criar o código para verificar se já existe um cartão que foi selecionado
                    System.out.print("\033[H\033[2J");
                    System.out.println("====== Número máximo de cartões atingidos! ======");

                    System.out.println();
                    System.out.println("Você tem " + usuarios.get(i).getQuantidadeCartoes() + " cartões cadastrados");
                    for(int indexCartoes = 0; indexCartoes < usuarios.get(i).getNumerosCartoes(); indexCartoes++){
                    
                    System.out.println();
                    System.out.println("Tipo do cartão: " + usuarios.get(i).getCartao(indexCartoes).getTipoDoCartaoDescricao());
                    System.out.println("ID: "+ usuarios.get(i).getCartao(indexCartoes).getId());
                    System.out.printf("Saldo atual: R$%.2f %n",usuarios.get(i).getCartao(indexCartoes).getSaldoNoCartao());
                    }

                    System.out.println("=================================================");
                    System.out.println();
                    System.out.println("Clique ENTER para continuar.");
                    entrada.nextLine();
                    System.out.print("\033[H\033[2J");
                    break;
                    //ESCREVER Código para mostrar os cartões, id e retornar ao menu
                    }
            } 
        
        }

        if(!(cpfEncontrado)){
            System.out.print("\033[H\033[2J");
            System.out.println("O CPF " + cpfDigitado  + " não foi encontrado!");
            System.out.println("Clique ENTER para continuar.");
            entrada.nextLine();
        }
    }

    public static int gerarID(ArrayList<Integer> idsCadastrados) {

        Random range = new Random();
        int idGerado = 0;
        boolean idNaoExiste = true;
        
        while(idNaoExiste) {
            idGerado = range.nextInt(99999 - 10000 + 1) + 10000;
            
            if(!idsCadastrados.contains(idGerado)) {
                idsCadastrados.add(idGerado);
                idNaoExiste = false;
            }
        }
        
        return idGerado;
    }


    public static Integer verificarCartao(ArrayList<Usuario> usuarios, int indexDoUsuario, TipoCartao tipoDoCartao){

        for(int i = 0; i < usuarios.get(indexDoUsuario).getNumerosCartoes(); i++){
            if(usuarios.get(indexDoUsuario).getCartao(i) != null){
                if(usuarios.get(indexDoUsuario).getCartao(i).getTipoDoCartao() == tipoDoCartao){
                    return i;
                }
            }
        }
        return null;
    }
}
