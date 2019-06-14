package jpb.exercicio4;

import java.util.concurrent.RecursiveTask;

public class FibonacciSum extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int n = 0;

	public FibonacciSum(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {

		if (n == 1) {
			return 0;
		}
		if (n <= 3) {
			return 1;
		}

		FibonacciSum left = new FibonacciSum(n - 1);
		FibonacciSum right = new FibonacciSum(n - 2);

		left.fork();
		right.fork();

		Integer sum = left.join() + right.join();
		return sum;

	}

}
