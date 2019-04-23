package jpb.exercicio3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	static final int NUM_PRODUTORES = 1;
	static final int NUM_CONSUMIDORES = 1;

	public static void main(String[] args) {

		Buffer buffer = new Buffer();

		ExecutorService service = Executors.newFixedThreadPool(NUM_CONSUMIDORES + NUM_CONSUMIDORES);

		Consumidor[] consumidores = new Consumidor[NUM_CONSUMIDORES];
		Produtor[] produtores = new Produtor[NUM_PRODUTORES];

		for (int i = 0; i < NUM_CONSUMIDORES; i++) {
			consumidores[i] = new Consumidor(buffer);
			service.execute(consumidores[i]);
		}
		
		for (int i = 0; i < NUM_PRODUTORES; i++) {
			produtores[i] = new Produtor(buffer);
			service.execute(produtores[i]);
		}

		service.shutdown();

	}

}
