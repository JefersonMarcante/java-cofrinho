package Uninter;
/**
 * Classe Moeda
 * 
 * Classe abstrata mãe para as moedas de Dolar, Euro e Real.
 * 
 * @author Jeferson Marcante
 * @version	2023-09-29
 */

public abstract class Moeda {
	private double valor;
	
	/**
	 * Construtor da classe 
	 * 
	 * @param valor	o valor da moeda
	 */
	Moeda(double valor){
		this.valor = valor;
	}
	
	/**
	 * Retorna o valor da moeda
	 * 
	 * @return valor da moeda 
	 */
	public double getValor() {
		return valor;
	}
	
	/**
	 * Modifica o valor da moeda
	 * 
	 * @param valor valor da moeda a ser modificado 
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * Métodos abstratos
	 */
	public abstract void info();
	public abstract double converter();

}
