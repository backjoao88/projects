package curso.java.jpb.arquivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import curso.java.jpb.agenda.Contato;
import curso.java.jpb.exceptions.ArquivoException;

public class ManipArquivoContato {

	private final static String NOME_ARQUIVO = "contatos.txt";
	private final static String DIRETORIO_ARQUIVO = "src/curso/java/jpb/arquivos/";

	public static List<Contato> ler() throws ArquivoException {
		
		List<Contato> contatos = new ArrayList<Contato>();

		try (Scanner reader = new Scanner(new FileInputStream(DIRETORIO_ARQUIVO + NOME_ARQUIVO))) {

			while (reader.hasNext()) {
				String str = reader.nextLine();
				String[] atributos = str.split(",");
				Contato contato = new Contato(atributos[0], atributos[1]);
				contatos.add(contato);
			}

		} catch (IOException e) {
			throw new ArquivoException("Erro ao ler no arquivo");
		}

		return contatos;

	}
	

	public static void gravar(Collection<Contato> contatos) throws ArquivoException {

		try (PrintStream writer = new PrintStream(new FileOutputStream(DIRETORIO_ARQUIVO + NOME_ARQUIVO))) {
			Iterator<Contato> it;
			for (it = contatos.iterator(); it.hasNext();) {
				Contato cont = it.next();
				writer.print(cont.getNome());
				writer.print(",");
				writer.println(cont.getTelefone());
			}

		} catch (IOException e1) {
			throw new ArquivoException("Erro ao gravar no arquivo.");
		}

	}

}
