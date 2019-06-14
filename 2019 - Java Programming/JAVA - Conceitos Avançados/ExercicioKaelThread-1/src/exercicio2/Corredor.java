package exercicio2;

import static java.lang.Math.random;

/**
 * Classe responsável por representar um corredor. Implementa a interface
 * Runnable.
 * 
 * @author João Paulo Back
 *
 */

public class Corredor implements Runnable {

	/**
	 * Atributo estático para representar a colocação final do corredor.
	 * 
	 */
	private static int colocacao = 0;

	/**
	 * Código do corredor, para identificá-lo no final da corrida.
	 */

	private int codigo = 0;

	/**
	 * 
	 * Atributo inteiro que representa a distância total percorrida pelo corredor. É
	 * dado pelas somas dos números aleatórios gerador pelo método Math.random();
	 * 
	 */
	private int distanciaTotalPercorrida = 0;

	/**
	 * Atributo inteiro que representa a distância total a ser percorrida pelo
	 * corredor. Esse atributo é provindo de forma externa.
	 * 
	 */

	private int distanciaAPercorrer = 0;

	public Corredor(int distanciaAPercorrer, int codigo) {
		setDistanciaAPercorrer(distanciaAPercorrer);
		setCodigo(codigo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDistanciaAPercorrer() {
		return distanciaAPercorrer;
	}

	public void setDistanciaAPercorrer(int distanciaAPercorrer) {
		this.distanciaAPercorrer = distanciaAPercorrer;
	}

	public int getDistanciaTotalPercorrida() {
		return distanciaTotalPercorrida;
	}

	public void setDistanciaTotalPercorrida(int distanciaTotalPercorrida) {
		this.distanciaTotalPercorrida = distanciaTotalPercorrida;
	}

	public void correr(int distanciaPercorrida) {
		setDistanciaTotalPercorrida(getDistanciaTotalPercorrida() + distanciaPercorrida);
		// trunca o atributo distanciaTotalPercorrida caso ele for maior que a distância
		// total.
		if (getDistanciaTotalPercorrida() > getDistanciaAPercorrer()) {
			setDistanciaTotalPercorrida(getDistanciaAPercorrer());
		}

		// atualiza as informações

		System.out.println("O corredor " + codigo + " correu --> " + distanciaPercorrida + " m, total percorrido: "
				+ getDistanciaTotalPercorrida() + "m.");

	}

	@Override
	public void run() {
		// enquanto a distância que o corredor percorreu for menor que a distancia total
		// a ser percorrida

		while (getDistanciaTotalPercorrida() < getDistanciaAPercorrer()) {

			// gera numero aleatório

			int distanciaAPercorrer = (int) (random() * 10);

			// corre
			correr(distanciaAPercorrer);

			// o corredor aguarda por 0,2 segundos

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// ao sair do loop, o atributo colocacao é atribuído indicando que um corredor
		// chegou a linha de chegada

		colocacao++;

		// atualiza as informações

		System.out.println("O corredor " + codigo + " terminou em " + colocacao + "º colocado.");
	}

}
