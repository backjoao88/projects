package jpb.exercicio2;

public class Papel {

	static Integer objCounters = 0;

	public enum Cor {
		BRANCO, PRETO, AZUL, AMARELO
	}

	private Integer id;
	private Cor cor;

	public Papel(Integer id, Cor cor) {
		setId(id);
		setCor(cor);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Papel [id=");
		builder.append(id);
		builder.append(", cor=");
		builder.append(cor);
		builder.append("]");
		return builder.toString();
	}

}
