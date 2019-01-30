package br.poo.joao.classes;

/**
 * A classe <code>DadoComDoisParametros</code> é responsável por representar
 * dado que possua dois parâmetros.
 * 
 */

public class DadoComDoisParametros extends Dado {

	/**
	 * Atributo private do tipo int que representa o parâmetro um de um tipo de dado
	 * com dois parâmetros
	 * 
	 */

	private int parametroUm;

	/**
	 * Atributo private do tipo int que representa o parâmetro dois de um tipo de
	 * dado com dois parâmetros
	 * 
	 */

	private int parametroDois;

	public int getParametroUm() {
		return parametroUm;
	}

	public void setParametroUm(int parametroUm) {
		this.parametroUm = parametroUm;
	}

	public int getParametroDois() {
		return parametroDois;
	}

	public void setParametroDois(int parametroDois) {
		this.parametroDois = parametroDois;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DadoComDoisParametros [parametroUm=");
		builder.append(parametroUm);
		builder.append(", parametroDois=");
		builder.append(parametroDois);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
