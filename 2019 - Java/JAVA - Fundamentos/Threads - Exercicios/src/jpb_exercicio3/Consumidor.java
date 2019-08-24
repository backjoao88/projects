package jpb_exercicio3;

public class Consumidor extends Thread {

	private int id = 0;
	private Buffer buffer = null;

	public Consumidor(Buffer buffer, int id) {
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

	public void consumir() throws InterruptedException {
		while (true) {
			synchronized (buffer.getMonitor()) {
				if ("PRODUTOR".equalsIgnoreCase(buffer.getVez())) {
					buffer.getMonitor().wait();
				}
				while (true) {
					if (buffer.getQuantidade() == 0) {
						break;
					}
					Thread.sleep(300);
					buffer.setQuantidade(buffer.getQuantidade() - 1);
					System.out.println("CONSUMIDOR " + this.getId() + " CONSUMIU 1 PEÇA!");
					System.out.println(buffer);
				}

				buffer.setVez("PRODUTOR");
				System.out.println("Fim do consumo! Acordando o produtor.\n");
				buffer.getMonitor().notify();

				while (buffer.getVez().equals("PRODUTOR")) {

					buffer.getMonitor().wait();
				}
			}
		}
	}

	public void run() {

		try {
			consumir();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
