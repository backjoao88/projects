package jpb.exercicio4;

import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		for (int k = 1; k <= 30; k++) {
			FibonacciSum task = new FibonacciSum(k);
			int v = pool.invoke(task);
			System.out.print(v +" ");
		}
	}

}
