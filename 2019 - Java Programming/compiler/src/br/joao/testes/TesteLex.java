package br.joao.testes;

import java.util.Scanner;

import br.joao.lex.TokenRegex;

public class TesteLex {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe uma entrada: ");
		
		String entrada = scan.nextLine();
		
		for (TokenRegex t : TokenRegex.values()) {
			
			int end = t.sizeOfLexem(entrada);
			if (end != -1) {
				System.out.println(end);
				break;
			}

		}
		
		scan.close();
		
	}

}
