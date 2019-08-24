package jpb_exercicio4;

public class Embalagem {

	private Peca peca = null;
	private boolean lacrado = false;

	public Embalagem() {
		this.lacrado = false;
		this.peca = null;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public boolean isLacrado() {
		return lacrado;
	}

	public void setLacrado(boolean lacrado) {
		this.lacrado = lacrado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Embalagem [peca=");
		builder.append(peca);
		builder.append(", lacrado=");
		builder.append(lacrado);
		builder.append("]");
		return builder.toString();
	}

}
