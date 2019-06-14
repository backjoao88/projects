	package curso.java.jpb.agenda;

import static curso.java.jpb.arquivos.ManipArquivoContato.gravar;
import static curso.java.jpb.arquivos.ManipArquivoContato.ler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import curso.java.jpb.exceptions.AgendaException;
import curso.java.jpb.exceptions.ArquivoException;

public class Agenda {

	private Map<String, Contato> contatos;

	private Map<Character, List<Contato>> contatosPorLetra;

	public Agenda() throws ArquivoException {
		contatos = new TreeMap<String, Contato>();
		contatosPorLetra = new TreeMap<Character, List<Contato>>();
		List<Contato> contatos = ler();
		for (int k = 0; k < contatos.size(); k++) {
			this.contatos.put(contatos.get(k).getNome(), contatos.get(k));
		}

		for (Contato c : contatos) {
			Character key = c.getNome().charAt(0);
			if (!contatosPorLetra.containsKey(key)) {
				contatosPorLetra.put(key, new ArrayList<Contato>());
			}
			contatosPorLetra.get(key).add(c);
		}

	}

	public Map<String, Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Map<String, Contato> contatos) {
		this.contatos = contatos;
	}

	public void inserir(Contato contato) throws AgendaException {

		if (contato == null) {
			throw new AgendaException("O contato a ser inserido é vazio.\n");
		}

		if (contatos.containsKey(contato.getNome())) {
			throw new AgendaException("O contato " + contato.getNome() + " já existe.\n");
		}

		// João
		// inicial = J
		contato.validarNome();
		contato.validarTelefone();
		
		contatos.put(contato.getNome(), contato);
		
		Character inicial = contato.getNome().charAt(0);
		
		if(!contatosPorLetra.containsKey(inicial)) {
			contatosPorLetra.put(inicial, new ArrayList<Contato>());
		}
		
		contatosPorLetra.get(inicial).add(contato);

		gravar(contatos.values());

	}

	public void remover(String chave) throws AgendaException {

		if (chave == null) {
			throw new AgendaException("A chave do contato a ser removido é vazia.\n");
		}

		if (!contatos.containsKey(chave)) {
			throw new AgendaException("O contato " + chave + " não existe.\n");
		}

		contatos.remove(chave);

		gravar(contatos.values());

	}

	public void alterar(String chave, Contato contato) throws AgendaException {

		if (chave == null) {
			throw new AgendaException("A chave do contato a ser removido é vazia.\n");
		}

		if (!contatos.containsKey(chave)) {
			throw new AgendaException("O contato " + chave + " não existe.\n");
		}

		contatos.replace(chave, contato);

		gravar((ArrayList<Contato>)contatos.values());

	}

	public List<Contato> listarTodos() throws ArquivoException {
		List<Contato> contatos = ler();
		return contatos;
	}

	public List<Contato> listarPorLetra(Character c) {
		return contatosPorLetra.get(c);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agenda [contatos=");
		builder.append(contatos);
		builder.append("]");
		return builder.toString();
	}

}
