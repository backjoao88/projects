package jpb_exercicio4;

public class Esteira {

	private Peca peca = null;
	private String vez = null;

	public Esteira() {
		setVez("FORNECEDOR");
	}

	public String getVez() {
		return vez;
	}

	public void setVez(String vez) {
		this.vez = vez;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Esteira [peca=");
		builder.append(peca);
		builder.append("]");
		return builder.toString();
	}

}
