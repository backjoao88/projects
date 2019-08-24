package curso.java.jpb.forca;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import curso.java.jpb.exceptions.LeituraArquivoException;
import curso.java.jpb.exceptions.PalavraNaoEncontradaException;

public class Sorteador {

	private final String NOME_ARQUIVO = "dicionario.txt";
	private static Sorteador instancia;

	private Sorteador() {

	}

	public static Sorteador getInstance() {
		if (instancia == null) {
			return new Sorteador();
		}
		return instancia;
	}

	public Palavra gerarPalavra() throws LeituraArquivoException, PalavraNaoEncontradaException  {
		
		int totalPalavras = 0;
		List<String> palavras = lerPalavras();
		
		try {
			totalPalavras = palavras.size() - 1;
			int opcao = (int) (Math.random() * totalPalavras) + 1;
			return new Palavra(parseString(palavras.get(opcao)));
			
		} catch (IndexOutOfBoundsException e) {
			throw new PalavraNaoEncontradaException("O arquivo "+ NOME_ARQUIVO + " não contém palavras.");
		}
	}

	private char[] parseString(String nome) {
		return nome.toUpperCase().toCharArray();
	}

	private List<String> lerPalavras() throws LeituraArquivoException {

		List<String> palavras = new ArrayList<String>();
		String linha = null;

		try (Scanner scan = new Scanner(new FileInputStream(NOME_ARQUIVO));) {

			while (scan.hasNext()) {
				linha = scan.nextLine();
				palavras.add(linha);
			}

			return palavras;

		} catch (IOException e) {
			throw new LeituraArquivoException("Ocorreu um erro com a leitura do arquivo: " + NOME_ARQUIVO);
		}

	}
}
