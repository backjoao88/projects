package jpb.exercicio2;

public class Carro {
	
	private String cor = null;

	public Carro() {
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public String toString() {
		return "Carro [cor=" + cor + "]";
	}


}
