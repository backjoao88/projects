package jpb_exercicio2;

public class Aplicacao {

	static final int NUM_THREADS = 2;

	static final int NUM_ITERACOES = 100;

	public static void main(String[] args) throws InterruptedException {

		double[] resultados = new double[NUM_THREADS];

		CalculadoraPI[] calculadora = new CalculadoraPI[NUM_THREADS];
		Thread[] threads = new Thread[NUM_THREADS];

		for (int k = 0; k < NUM_THREADS; k++) {
			calculadora[k] = new CalculadoraPI(k, resultados);
			threads[k] = new Thread(calculadora[k]);
			threads[k].start();
		}

		for (int k = 0; k < NUM_THREADS; k++) {
			threads[k].join();
		}

		double pi = 0;

		for (double res : resultados) {
			pi = pi + res;
		}
		
		System.out.println("Resultado do PI encontrado: "+pi);
		
	}

}
