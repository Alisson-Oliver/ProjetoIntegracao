import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class CadastroCartao {


    public static void cadastrarCartao(Scanner entrada, ArrayList<Usuario> usuarios, ArrayList<Integer> idsCadastrados){

        
        System.out.println("####### Cadastrar Cartão #######");
        entrada.nextLine();

        System.out.println("Digite o CPF:");
        String cpfDigitado = entrada.nextLine();

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getCpf().equals(cpfDigitado)){

                if(usuarios.get(i).cartoes[0] == null || usuarios.get(i).cartoes[1] == null ){

                    //Código para adcionar cartão
                    System.out.println();
                    System.out.println("Qual tipo de cartão deseja cadastrar?");
                    System.out.println("[1] Meia Passagem Estudantil");
                    System.out.println("[2] Bilhete Identificado");
                    int opcaoDigitada = entrada.nextInt();

                    
                    if(opcaoDigitada == 1){

                        Random range = new Random();
                        int idGerado = 00000;
                       
                
                        // CRIAÇÃO DE ID ÚNICO
                        boolean idNaoExiste = true;
                        while(idNaoExiste){
                
                            idGerado = range.nextInt(99999 - 10000 + 1) + 10000; 
                
                            if(idsCadastrados.size() == 0){
                
                                idsCadastrados.add(idGerado);
                                idNaoExiste = false;
                
                            } else{
                
                                for(int random = 0; random < idsCadastrados.size(); random++){
                                    if(idsCadastrados.get(random) != idGerado){
                
                                        idsCadastrados.add(idGerado);
                                        idNaoExiste = false;
                                    }
                
                            }
                
                            
                            }  
                        }


                        int indexCartao = 0;
                        for(int index = 0; index < 2; index++){

                            if(usuarios.get(i).cartoes[index] == null){
                                usuarios.get(i).cartoes[index] = new Cartao(idGerado, "Meia Passagem Estudantil");
                                indexCartao = index;
                            }

                        } 
                        System.out.println();
                        System.out.println("SEU CARTÃO FOI CRIADO!");
                        System.out.println("ID do cartão: " + idGerado);
                        System.out.println("Nome do titular: " + usuarios.get(i).nome);
                        System.out.println("Data de nascimento: " + usuarios.get(i).dataDeNascimento);
                        System.out.println("Tipo do cartão: " + usuarios.get(i).cartoes[indexCartao].getTipoDoCartao());
                        System.out.println("################################");
                        System.out.println();
                        
                        

                    }
            
                    else if(opcaoDigitada == 2){}
            
                    else{
                        System.out.println("Erro! Digite uma opção válida.");
                    }

                    //Criar o código para verificar se já existe um cartão que foi selecionado


                } else{

                    System.out.println("Número máximo de cartões atingidos!");
                    //ESCREVER Código para mostrar os cartões, id e retornar ao menu

                }
            }
        }

    





    }

    
}
