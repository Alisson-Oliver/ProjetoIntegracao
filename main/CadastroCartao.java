import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CadastroCartao {


    public static void cadastrarCartao(Scanner entrada, ArrayList<Usuario> usuarios, ArrayList<Integer> idsCadastrados){

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horasFormatada = DateTimeFormatter.ofPattern("HH:mm:ss");

        entrada.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.println("========== Cadastrar Cartão ==========");

        System.out.println("Digite o CPF:");
        String cpfDigitado = entrada.nextLine();

        boolean cpfNaoEncontrado = true;

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpfDigitado)){

                if(usuarios.get(i).cartoes[0] == null || usuarios.get(i).cartoes[1] == null ){

                    //Código para adcionar cartão
                    System.out.println();
                    System.out.println("Qual tipo de cartão deseja cadastrar?");
                    System.out.println("[1] Meia Passagem Estudantil");
                    System.out.println("[2] Bilhete Identificado");
                    System.out.println();
                    System.out.println("Digite a opção: ");
                    int opcaoDigitada = entrada.nextInt();
                    cpfNaoEncontrado = false;
                    
                    if(opcaoDigitada == 1){
                    
                        int cartaoExistente = verificarCartao(usuarios, i, "Meia Passagem Estudantil");

                        if(cartaoExistente == 0){
                                                 
                        //Chamar função para gerar o ID
                        int idGerado = gerarID(idsCadastrados);

                        int indexCartao = 0;
                        for(int index = 0; index < 2; index++){

                            if(usuarios.get(i).cartoes[index] == null){
                                usuarios.get(i).cartoes[index] = new Cartao(idGerado, "Meia Passagem Estudantil");
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
                        System.out.println("Tipo do cartão: " + usuarios.get(i).cartoes[indexCartao].getTipoDoCartao());
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
                        System.out.println("Você já tem um cartão Meia Passagem Estudantil");
                        System.out.println();
                        System.out.println("ID do cartão: " + cartaoExistente);
                        System.out.println("Nome do titular: " + usuarios.get(i).getNome());
                        System.out.println("CPF do TItular: " + usuarios.get(i).getCpf());
                        System.out.println("Data de nascimento: " + usuarios.get(i).getDataDeNascimento());
                        System.out.println();
                        System.out.println("Clique ENTER para continuar.");
                        entrada.nextLine();
                        entrada.nextLine();

                        break;
                        }
                    }

            
                    else if(opcaoDigitada == 2){

                        int cartaoExistente = verificarCartao(usuarios, i, "Bilhete Identificado");

                        if(cartaoExistente == 0){
                                                 
                        //Chamar função para gerar o ID
                        int idGerado = gerarID(idsCadastrados);

                        int indexCartao = 0;
                        for(int index = 0; index < 2; index++){

                            if(usuarios.get(i).cartoes[index] == null){
                                usuarios.get(i).cartoes[index] = new Cartao(idGerado, "Bilhete Identificado");
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
                        System.out.println("Tipo do cartão: " + usuarios.get(i).cartoes[indexCartao].getTipoDoCartao());
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
                        System.out.println("Você já tem um cartão Bilhete Identificado");
                        System.out.println();
                        System.out.println("ID do cartão: " + cartaoExistente);
                        System.out.println("Nome do titular: " + usuarios.get(i).getNome());
                        System.out.println("CPF do TItular: " + usuarios.get(i).getCpf());
                        System.out.println("Data de nascimento: " + usuarios.get(i).getDataDeNascimento());
                        System.out.println();
                        System.out.println("Clique ENTER para continuar.");
                        entrada.nextLine();
                        entrada.nextLine();

                        break;
                        }


                    } 
            
                    else{
                        System.out.println("Erro! Digite uma opção válida.");
                    }

                    //Criar o código para verificar se já existe um cartão que foi selecionado


                } else{

                    System.out.print("\033[H\033[2J");
                    System.out.println("====== Número máximo de cartões atingidos! ======");
                    cpfNaoEncontrado = false;

                    System.out.println("Você tem 2 cartões cadastrados");
                    System.out.println();
                    System.out.println("Tipo do cartão: " + usuarios.get(i).cartoes[0].getTipoDoCartao());
                    System.out.println("ID: "+ usuarios.get(i).cartoes[0].getId());
                    System.out.printf("Saldo atual: R$%.2f %n",usuarios.get(i).cartoes[0].getSaldoNoCartao());
                    System.out.println();
                    System.out.println("Tipo do cartão: " + usuarios.get(i).cartoes[1].getTipoDoCartao());
                    System.out.println("ID: "+ usuarios.get(i).cartoes[1].getId());
                    System.out.printf("Saldo atual: R$%.2f %n",usuarios.get(i).cartoes[1].getSaldoNoCartao());

                    System.out.println();
                    System.out.println("Clique ENTER para continuar.");
                    entrada.nextLine();
                    break;
                    //ESCREVER Código para mostrar os cartões, id e retornar ao menu
                }
            } 
        }

        if(cpfNaoEncontrado){
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


    public static int verificarCartao(ArrayList<Usuario> usuarios, int indexDoUsuario, String tipoDoCartao){
        for(Cartao cartao : usuarios.get(indexDoUsuario).cartoes){

            if(cartao != null){
                if(cartao.getTipoDoCartao().equals(tipoDoCartao)){
                    return cartao.getId();
                }
            }
        }
        return 0;
    }
}
