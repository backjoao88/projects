package jpb.exercicio1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Corrida {

	public final int NUM_SAPOS = 5;

	public void iniciar_corrida() throws Exception {

		ExecutorService service = Executors.newFixedThreadPool(NUM_SAPOS);

		for (int k = 0; k < NUM_SAPOS; k++) {
			service.execute(new Sapo(k));
		}
		
		service.shutdown();
	}

}
