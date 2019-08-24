package jpb_exercicio4;

public class Peca {

	private boolean apertado = false;
	private boolean soldado = false;

	public Peca() {
		this.apertado = false;
		this.soldado = false;
	}

	public boolean isApertado() {
		return apertado;
	}

	public void setApertado(boolean apertado) {
		this.apertado = apertado;
	}

	public boolean isSoldado() {
		return soldado;
	}

	public void setSoldado(boolean soldado) {
		this.soldado = soldado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Peca [apertado=");
		builder.append(apertado);
		builder.append(", soldado=");
		builder.append(soldado);
		builder.append("]");
		return builder.toString();
	}

}
