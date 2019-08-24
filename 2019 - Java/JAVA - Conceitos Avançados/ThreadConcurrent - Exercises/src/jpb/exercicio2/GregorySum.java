package jpb.exercicio2;

import java.util.concurrent.Callable;

public class GregorySum implements Callable<Double> {

	public int id = 0;
	private int start = 0;
	private int end = 0;

	public GregorySum(int id, int start, int end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	public Double sum() throws InterruptedException {
		double sum = 0;
		for (int i = start; i < end; i++) {
			if (i % 2 == 0) {			
				sum = sum + ((double) 1 / ((2 * i) + 1));
			} else {
				sum = sum + ((double) -1 / ((2 * i) + 1));
			}
		}
		System.out.println("Thread "+id+" retornando o valor: "+sum*4);
		return sum;
	}

	@Override
	public Double call() throws Exception {
		return sum() * 4;
	}

}
