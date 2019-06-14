package curso.java.jpb.testes;

import static curso.java.jpb.arquivos.ManipArquivoContato.gravar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import curso.java.jpb.agenda.Contato;
import curso.java.jpb.exceptions.ArquivoException;


public class TesteGravar {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Contato cont = new Contato("João", "8816-4143");
		Contato cont2 = new Contato("Gabriel", "9115-3689");
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		contatos.add(cont);
		contatos.add(cont2);
		
		try {
			gravar(contatos);
		}catch(ArquivoException ae) {
			System.err.println("Erro ao gravar no arquivo!.\n");
			ae.printStackTrace();
		}

		
		
	}

}
