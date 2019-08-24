package exercicio1;

public class Buffer {

	private int counter = 0;
	
	public Buffer(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public synchronized void increase() {
		counter++;
		System.out.println("\nO valor atual do buffer é --> " + getCounter());
	}

	public synchronized void decrease() {
		counter--;
		System.out.println("\nO valor atual do buffer é --> " + getCounter());
	}

}
