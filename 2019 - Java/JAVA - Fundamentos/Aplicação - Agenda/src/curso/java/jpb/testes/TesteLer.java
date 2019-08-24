package curso.java.jpb.testes;

import static curso.java.jpb.arquivos.ManipArquivoContato.ler;

import java.util.List;

import curso.java.jpb.agenda.Contato;
import curso.java.jpb.exceptions.ArquivoException;

public class TesteLer {
	
	public static void main(String[] args) {
		
		List<Contato> contatos = null;
		
		try {
			contatos = ler();
		}catch(ArquivoException ae) {
			System.err.println("Erro ao ler arquivo!\n");
			ae.printStackTrace();
		}

		for (int k = 0; k < contatos.size(); k++) {
			System.out.println(contatos.get(k));
		}

	}

}
