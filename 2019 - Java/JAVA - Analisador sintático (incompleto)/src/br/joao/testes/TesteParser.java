package br.joao.testes;

import br.joao.lex.Lexer;
import br.joao.parser.Parser;

public class TesteParser {
	
	public static void main(String[] args) {
	
		Lexer lex = new Lexer("arquivos/ifwhile.txt");
		Parser parser = new Parser(lex);
		boolean res = parser.parse();
		if (res) {
			System.out.println("Entrada sintaticamente correta!");
		}else {
			System.out.println("Entrada sintaticamente incorreta!");
		}
		
		// Printa a tabela de símbolos
		parser.st.print();
		
	}

}
