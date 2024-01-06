package Uninter;
/**
 * Classe Euro
 * 
 * Cria objeto Euro com atributos herdados da classe
 * mãe Moeda
 * 
 * @author Jeferson Marcante
 * @version	2023-09-30
 */

public class Euro extends Moeda {
	private final double currency = 5.36;
	
	/**
	 * Construtor da classe 
	 * 
	 * @param valor	o valor da moeda
	 */
	Euro(double valor){
		super(valor);
	}
	
	/**
	 * Lista valor da moeda
	 */
	@Override
	public void info() {
		System.out.printf("Moeda: EUR %9.2f\n", super.getValor());		
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
