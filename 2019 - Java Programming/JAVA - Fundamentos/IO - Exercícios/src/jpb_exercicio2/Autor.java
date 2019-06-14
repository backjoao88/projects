package jpb_exercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public class Autor implements Recordable {

	private String nome = null;
	private Date dataNascimento = null;
	
	public Autor() {
		
	}

	public Autor(String nome, Date dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Autor [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void read(DataInputStream in) throws IOException {
	
		this.nome = in.readUTF();
		long time = in.readLong();
		Date date = new Date(time);
		this.dataNascimento = date;
		
	}

	@Override
	public void write(DataOutputStream out) throws IOException {
		
		out.writeUTF(nome);
		long time = dataNascimento.getTime();
		out.writeLong(time);

	}

}
