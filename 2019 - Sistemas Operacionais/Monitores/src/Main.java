
public class Main {

	final static int NUM_THREADS = 2;
	final static int NUM_ITERACOES = 10;

	public static void main(String[] args) {

		int[] array = { 2, 3, 4, 5, 6, 7, 8, 10, 14, 15 };

		for (int i = 0; i < NUM_THREADS; i++) {
			Soma soma = new Soma(i);
			
			
			for (int j = soma.getId(); j < NUM_ITERACOES; j += NUM_THREADS) {
				
			}

		}

	}

}
