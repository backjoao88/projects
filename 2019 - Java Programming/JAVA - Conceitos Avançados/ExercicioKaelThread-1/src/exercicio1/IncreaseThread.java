package exercicio1;

public class IncreaseThread implements Runnable {

	private Buffer buffer = null;

	public IncreaseThread(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		buffer.increase();
	}

}
