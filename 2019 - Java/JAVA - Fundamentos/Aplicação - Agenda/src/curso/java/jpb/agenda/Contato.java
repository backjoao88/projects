package curso.java.jpb.agenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import curso.java.jpb.exceptions.AgendaException;

public class Contato {

	private String nome = null;
	private String telefone = null;

	public Contato(String nome, String telefone) {
		setNome(nome);
		setTelefone(telefone);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void validarNome() throws AgendaException {

		if (getNome() != null || getNome().trim().length() == 0) {

			// Regex para nomes
			
			String regex = "[A-Z]([\\S]*)";

			Pattern pattern = Pattern.compile(regex);

			Matcher matcher = pattern.matcher(getNome());

			if (!matcher.matches()) {
				throw new AgendaException("O nome do contato não é valido.\n");
			}
		} else {
			throw new AgendaException("O nome do contato não é valido.\n");
		}
	}

	public void validarTelefone() throws AgendaException {

		// Expressão regular para números de telefone

		String regex = "\\d\\d\\d\\d-\\d\\d\\d\\d";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(getTelefone());

		if (!matcher.matches()) 
			throw new AgendaException("O telefone do contato não é valido.\n");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [nome=");
		builder.append(nome);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append("]");
		return builder.toString();
	}

}
