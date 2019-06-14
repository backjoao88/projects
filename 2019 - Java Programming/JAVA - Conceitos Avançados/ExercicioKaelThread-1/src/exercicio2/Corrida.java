package exercicio2;

/**
 * Classe para representar uma corrida. Responsável por instanciar as threads(corredores) e iniciá-las.
 * 
 * @author João Paulo Back
 *
 */
public class Corrida {

	private final static int DISTANCIA_TOTAL = 100; //distancia total a ser percorrida pelos corredores

	private final static int NUM_CORREDORES = 2; // número de corredores (threads)

	public static void main(String[] args) {

		// bloco for que percorrerá todo o número de corredores e irá instanciá-los 
		
		for (int i = 0; i < NUM_CORREDORES; i++) {
			Corredor corredor = new Corredor(DISTANCIA_TOTAL, i + 1);
			Thread thread = new Thread(corredor);
			thread.start();
		}

	}

}
