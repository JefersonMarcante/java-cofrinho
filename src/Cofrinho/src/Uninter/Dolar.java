package Uninter;
/**
 * Classe Dolar
 * 
 * Cria objeto Dolar com atributos herdados da classe
 * mãe Moeda
 * 
 * @author Jeferson Marcante
 * @version	2023-09-30
 */

public class Dolar extends Moeda {
	private final double currency = 4.98;
	
	/**
	 * Construtor da classe 
	 * 
	 * @param valor	o valor da moeda
	 */
	Dolar(double valor){
		super(valor);
	}
	
	/**
	 * Lista valor da moeda
	 */
	@Override
	public void info() {
		System.out.printf("Moeda: USD %9.2f\n", Dolar.super.getValor());
	}
	
	/**
	 * Retorna valor convertido para real
	 * 
	 * @return valor da moeda em reais
	 */
	@Override
	public double converter() {
		return currency * super.getValor();
	}
}
