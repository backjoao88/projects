package jpb_exercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Livro implements Recordable {

	private String titulo = null;
	private int numPaginas = 0;
	private Autor autor = null;

	public Livro() {

	}

	public Livro(String titulo, int numPaginas, Autor autor) {
		this.titulo = titulo;
		this.numPaginas = numPaginas;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livro [titulo=");
		builder.append(titulo);
		builder.append(", numPaginas=");
		builder.append(numPaginas);
		builder.append(", autor=");
		builder.append(autor);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void read(DataInputStream in) throws IOException {

		this.titulo = in.readUTF();
		this.numPaginas = in.readInt();
		autor = new Autor();
		autor.read(in);

	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		out.writeUTF(titulo);
		out.writeInt(numPaginas);
		autor.write(out);
	}

}
