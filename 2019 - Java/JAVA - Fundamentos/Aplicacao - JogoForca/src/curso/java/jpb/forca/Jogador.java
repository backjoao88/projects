package curso.java.jpb.forca;

public class Jogador {

	private String nome = null;
	
	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jogador [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

}
