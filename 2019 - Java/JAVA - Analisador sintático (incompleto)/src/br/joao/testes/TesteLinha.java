package br.joao.testes;

import java.io.IOException;

import br.joao.utils.FileUtils;

public class TesteLinha {
	
	public static void main(String[] args) throws IOException {
		
		String lido = FileUtils.inputFileToString("arquivos/arquivo.txt");
		
		boolean a = lido.matches("");
		
		System.out.println(a);
		
	}

}
