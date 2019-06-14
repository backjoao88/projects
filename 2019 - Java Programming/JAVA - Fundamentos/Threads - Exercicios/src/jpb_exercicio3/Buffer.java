package jpb_exercicio3;

public class Buffer {

	protected final int MAXIMO_BUFFER = 5;

	private String vez = null;
	private int quantidade = 0;

	private static Object monitor = null;

	public Buffer() {
		quantidade = 0;
		vez = "PRODUTOR";
		monitor = new Object();
	}

	public Object getMonitor() {
		return monitor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getMAXIMO_BUFFER() {
		return MAXIMO_BUFFER;
	}

	public String getVez() {
		return vez;
	}

	public void setVez(String vez) {
		this.vez = vez;
	}

	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Quantidade no Buffer: ");
		strBuilder.append(quantidade + "\n");
		strBuilder.append("Quantidade Máxima suportada pelo buffer: ");
		strBuilder.append(MAXIMO_BUFFER + "\n");
		return strBuilder.toString();
	}
}