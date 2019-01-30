package br.poo.joao.classes;

/**
 * A classe <code>DadoComUmParametro</code> � respons�vel por representar dado que possua
 * um par�metro.
 * 
 * */

public class DadoComUmParametro extends Dado{
	
	private int parametroUm;

	public int getParametroUm() {
		return parametroUm;
	}

	public void setParametroUm(int parametroUm) {
		this.parametroUm = parametroUm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DadoComTamanho [parametroUm=");
		builder.append(parametroUm);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
