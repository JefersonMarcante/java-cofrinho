/**
 * Classe Cofrinho
 * 
 * Armazena moedas inseridas através de uma ArrayList
 * 
 * @author Jeferson Marcante
 * @version	2023-09-01
 */
package Uninter;

import java.util.ArrayList;

public class Cofrinho {
	private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	/**
	 * Adiciona uma moeda à listaMoedas
	 * 
	 * @param moeda   moeda a adicionada
	 */
	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda);
	
	}

	/**
	 * Remove moedas especifica contida em listaMoedas
	 * 
	 * @param moeda   moeda a ser comparada para remoção
	 */
	public void remover(Moeda moeda) {
		for (Moeda m : listaMoedas) {
			if(m.getClass() == moeda.getClass() && m.getValor() == moeda.getValor()) {
				listaMoedas.remove(m);
				return;
			}
		}
	}

	/**
	 * Mostra a informação de todas as moedas contidas em listaMoedas
	 */
	public void listagemMoedas() {
		for (Moeda moeda : listaMoedas) {
			moeda.info();
		}
	}
	
	/**
	 * Calcula em real todas as moedas contidas em listaMoedas.
	 * Chama o método converte para todas as moedas que estão na lista.
	 * 
	 * @return soma das moedas em reais
	 */
	public double totalConvertido() {
		double total = 0;
		for (Moeda moeda : listaMoedas) {
			total += moeda.converter();
		}
		return total;
	}
}
