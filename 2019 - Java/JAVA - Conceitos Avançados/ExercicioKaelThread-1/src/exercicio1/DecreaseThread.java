package exercicio1;

public class DecreaseThread implements Runnable {

	private Buffer buffer = null;

	public DecreaseThread(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		buffer.decrease();
	}

}
