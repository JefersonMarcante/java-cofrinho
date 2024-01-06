/**
 * Atividade pratica de Programação Orientada a Objetos
 * 
 * O trabalho consiste em implementar um "Cofrinho de moedas" em Java. 
 * 
 * O programa contempla um menu para adicionar, remover, listar e converter para
 * real moedas do  cofrinho.
 * 
 * A didática deste trabalho é reforçar os conceitos de herança e polimorfismo
 * apresentados na aula.
 * 
 * @author Jeferson Marcante
 * @version	2023-09-03
 */
package Uninter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Instância cofrinho
		Cofrinho cofrinho = new Cofrinho();
	
		// Instância teclado
		Scanner teclado = new Scanner(System.in);
		int user = -1;
		
		// Lista de opções do menu
		enum opcoes {
			MENU_INICIAL,
			MENU_MOEDA,
			MENU_QUANTIDADE,
			MENU_CONFIRMA,
			MENU_LISTAR,
			MENU_TOTAL,
			MENU_SAIR;
		}
		opcoes menu = opcoes.MENU_INICIAL;
		
		// Variareis de controle de operação 
		int operacao = -1;
		int moeda = -1;
		double qnt = -1;
		
		while(true){
			System.out.println("\n--------------------------------\n");
			
			switch (menu) {
			case MENU_INICIAL: {
				// "Limpa" variareis
				operacao = -1;
				qnt = -1;
				moeda = -1;
				
				System.out.print("Cofrinho: \n\n"
							   + "Tecle 1 para Adicionar moeda.\n"
							   + "Tecle 2 para Remover moeda.\n"
							   + "Tecle 3 para Listar moedas.\n"
							   + "Tecle 4 para Calcular total de moedas em Real.\n"
							   + "Tecle 0 para Sair.\n"
							   + "Informe a opção desejada:");
				try {
					user = teclado.nextInt();		// Lê o que foi digitado pelo usuário
				} catch (InputMismatchException e){	// Captura exceção por valor invalido
					System.out.println("Erro: Valor invalido.");
					teclado.close();				// Finaliza objeto teclado
					return;
				}
				
				// Seleções do menu
				if		(user == 1) { 			// Se digitou 1, vai ao menu Adicionar moedas
					menu = opcoes.MENU_MOEDA;
					operacao = 1;
				}
				else if (user == 2) {			// Se digitou 2, vai ao menu Remover moedas
					menu = opcoes.MENU_MOEDA;
					operacao = 2;
				}
				else if (user == 3) menu = opcoes.MENU_LISTAR;	// Se digitou 3, vai ao menu Listar moedas
				else if (user == 4) menu = opcoes.MENU_TOTAL;	// Se digitou 4, vai ao menu Calcular moedas
				else if (user == 0) menu = opcoes.MENU_SAIR;	// Se digitou 0, finaliza programa
				else System.out.println("Opção invalida! Tente novamente."); // Se digitou algo diferente, volta a este menu
				
				break;
			}
			case MENU_MOEDA: { // Menu: Adicionar/Remover moeda (Seleciona moeda)
				// "Limpa" variareis
				qnt = -1;
				moeda = -1;
				
				System.out.printf("Escolha a moeda desejada para %s:\n\n"
						   		+ "Tecle 1 para Dólar.\n"
								+ "Tecle 2 para Euro.\n"
								+ "Tecle 3 para Real.\n"
								+ "Tecle 0 para Cancelar.\n"
								+ "Informe a opção desejada:", (operacao == 1)? "adicionar":"retirar");
				
				try {
					user = teclado.nextInt();		// Lê o que foi digitado pelo usuário
				} catch (InputMismatchException e){	// Captura exceção por valor invalido
					System.out.println("Erro: Valor invalido.");
					teclado.close();				// Finaliza objeto teclado
					return;
				}
				
				if (user == 0) {				// Se digitou 0, volta ao menu inicial
					menu = opcoes.MENU_INICIAL;
					break;
				}
				else if (user == 1) moeda = 1;	// Se digitou 1, seleciona Dólar
				else if (user == 2) moeda = 2;	// Se digitou 2, seleciona Euro
				else if (user == 3) moeda = 3;	// Se digitou 3, seleciona Real
				else break;					// Se digitou algo diferente, volta a este menu
			}
			case MENU_QUANTIDADE:{	// Menu: Adicionar/Remover moeda (Quantidade)
				// "Limpa" variareis
				qnt = -1;
				
				System.out.printf("\n\nOperação: %s\n",(operacao == 1)? "Adicionar":"Retirar");
				System.out.printf("Moeda: %s\n",(moeda == 1)?"Dolar":(moeda == 2)?"Euro":"Real");
				System.out.printf("Informe o valor desejado:");
				
				try {
					qnt = teclado.nextDouble();		// Lê o que foi digitado pelo usuário
				} catch (InputMismatchException e){	// Captura exceção por valor invalido
					System.out.println("Erro: Valor invalido.");
					teclado.close();				// Finaliza objeto teclado
					return;
				}
				
				if (user <= 0) {				// Se for menor ou igual a 0, cancela a operação
					System.out.print("Operação cancelada.");
					menu = opcoes.MENU_INICIAL;
					break;					
				}
				
				// Se não, vai para aproximo menu				
			}
			case MENU_CONFIRMA:{	// Menu: Adicionar/Remover moeda (Confirmação)
				System.out.printf("\n\nVoce esta %s: ",(operacao == 1)? "Adicionar":"Retirar");
				System.out.printf("%.2f de %s", qnt,(moeda == 1)?"Dolar":(moeda == 2)?"Euro":"Real");
				System.out.printf("Deseja confirmar a operação (1 para sim) ou (2 para nao):");
				
				try {
					user = teclado.nextInt();		// Lê o que foi digitado pelo usuário
				} catch (InputMismatchException e){	// Captura exceção por valor invalido
					System.out.println("Erro: Valor invalido.");
					teclado.close();				// Finaliza objeto teclado
					return;
				}
				
				if (user == 1) {	// Se o usuário confirmou (sim) a operação
					if (operacao == 1) { // Se for operação de adicionar moeda
						if 		(moeda == 1) cofrinho.adicionar(new Dolar(qnt)); 	// Se for Dólar, adiciona Dólar
						else if (moeda == 2) cofrinho.adicionar(new Euro(qnt));		// Se for Euro, adiciona Euro
						else if (moeda == 3) cofrinho.adicionar(new Real(qnt));		// Se for Real, adiciona Real
						else menu = opcoes.MENU_INICIAL;
					}
					else if (operacao == 2){ 
						if 		(moeda == 1) cofrinho.remover(new Dolar(qnt));		// Se for Dólar, retira Dólar
						else if	(moeda == 2) cofrinho.remover(new Euro(qnt));		// Se for Euro, retira Euro
						else if	(moeda == 3) cofrinho.remover(new Real(qnt));		// Se for Real, retira Real
						else menu = opcoes.MENU_INICIAL;
					}
				}
			
				menu = opcoes.MENU_INICIAL;

				break;
			}
			case MENU_LISTAR: {	// Menu: Lista todas moeda
				System.out.println("Moedas no cofrinho:");
				System.out.println("---------------------");
				cofrinho.listagemMoedas();
				System.out.println("---------------------");

				System.out.println("Precione qualquer tecla para voltar.");
				
				try {
					user = teclado.nextInt();		// Lê o que foi digitado pelo usuário
				} catch (InputMismatchException e){	// Captura exceção por valor invalido
					System.out.println("Erro: Valor invalido.");
					teclado.close();				// Finaliza objeto teclado
					return;
				}
				
				menu = opcoes.MENU_INICIAL;
				
				break;
			}
			case MENU_TOTAL: {	// Menu: Converte e soma todas moeda para real 
				System.out.println("---------------------");
				System.out.printf("Total: BRL %9.2f\n", cofrinho.totalConvertido());
				System.out.println("---------------------");
				System.out.println("Precione qualquer tecla para voltar.");
				
				try {
					user = teclado.nextInt();		// Lê o que foi digitado pelo usuário
				} catch (InputMismatchException e){	// Captura exceção por valor invalido
					System.out.println("Erro: Valor invalido.");
					teclado.close();				// Finaliza objeto teclado
					return;
				}
				
				menu = opcoes.MENU_INICIAL;
				
				break;
			}
			case MENU_SAIR: {	// Sair do programa
				System.out.println("Operação finalizada.\n"
								 + "Tenha um otimo dia!");
				
				teclado.close();// Finaliza objeto teclado
				
				return ;		// Finaliza programa				
			}	
			default:	// Caso algo inesperado ocorra
				System.out.println("Opcao invalida!");
				menu = opcoes.MENU_INICIAL;
			}		
		}
	}
}
