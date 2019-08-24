package jpb.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {

	/**
	 * Número de threads
	 */

	final static int THREADS_NUMBER = 2;

	/**
	 * Valor N do somatório
	 */

	final static int N = 55;

	/**
	 * Vetor responsável por armazenar os somatórios parciais trazidos pelas Threads
	 * 
	 */

	static Double[] summingArray = new Double[THREADS_NUMBER];

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<FutureTask<Double>> tasks = new ArrayList<FutureTask<Double>>();

		int sumsNumber = (int)Math.ceil(N / THREADS_NUMBER);

		ExecutorService service = Executors.newFixedThreadPool(THREADS_NUMBER);

		int start = 0;
		int end = sumsNumber;

		for (int i = 0; i < THREADS_NUMBER; i++) {
			if(i == THREADS_NUMBER-1) {
				end = N;
			}
			System.out.println("Start --> " + start + ", End --> " + end);
			FutureTask<Double> task = new FutureTask<>(new GregorySum(i, start, end));
			tasks.add(task);
			service.execute(task);
			start = end;
			end = end + sumsNumber;
		}

		service.shutdown();

		double totalSum = tasks.stream().mapToDouble(task -> {
			try {
				return task.get();
			} catch (InterruptedException | ExecutionException e) {
				return 0;
			}
		}).sum();

		System.out.println(totalSum);

	}

}
