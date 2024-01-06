package Uninter;
/**
 * Classe Real
 * 
 * Cria objeto Real com atributos herdados da classe
 * mãe Moeda
 * 
 * @author Jeferson Marcante
 * @version	2023-09-30
 */

public class Real extends Moeda {
	

	/**
	 * Construtor da classe 
	 * 
	 * @param valor	o valor da moeda
	 */
	Real(double valor){
		super(valor);
	}

	/**
	 * Lista valor da moeda
	 */
	@Override
	public void info() {
		System.out.printf("Moeda: BRL %9.2f\n", super.getValor());		
	}
	
	/**
	 * Retorna valor da moeda
	 * 
	 * @return valor da moeda em reais
	 */
	@Override
	public double converter() {
		return super.getValor();
	}
}
