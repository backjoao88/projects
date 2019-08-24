package exercicio2;

public class Livro {

	private short id = 0;
	private short tamNome = 0;
	private String nome = null;
	private int numPaginas = 0;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getTamNome() {
		return tamNome;
	}

	public void setTamNome(short tamNome) {
		this.tamNome = tamNome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livro [id=");
		builder.append(id);
		builder.append(", tamNome=");
		builder.append(tamNome);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", numPaginas=");
		builder.append(numPaginas);
		builder.append("]");
		return builder.toString();
	}

}
