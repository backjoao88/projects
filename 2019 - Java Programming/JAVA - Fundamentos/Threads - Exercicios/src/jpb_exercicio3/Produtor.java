package jpb_exercicio3;

public class Produtor extends Thread {

	private int id = 0;
	private Buffer buffer = null;

	public Produtor(Buffer buffer, int id) {
		this.id = id;
		this.buffer = buffer;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public void produzir() throws InterruptedException {
		while (true) {
			synchronized (buffer.getMonitor()) {
				while (true) {
					if (buffer.getQuantidade() >= buffer.getMAXIMO_BUFFER()) {
						break;
					}
					Thread.sleep(300);
					buffer.setQuantidade(buffer.getQuantidade() + 1);
					System.out.println("PRODUTOR " + this.getId() + " PRODUZIU 1 PEÇA!");
					System.out.println(buffer);
				}

				buffer.setVez("CONSUMIDOR");
				System.out.println("Fim da produção! Acordando o consumidor.\n");
				buffer.getMonitor().notify();

				while ("CONSUMIDOR".equalsIgnoreCase(buffer.getVez())) {
					buffer.getMonitor().wait();
				}
			}
		}
	}

	public void run() {
		try {
			produzir();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}