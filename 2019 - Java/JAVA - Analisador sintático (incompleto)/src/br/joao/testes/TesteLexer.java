package br.joao.testes;

import br.joao.lex.Lexer;

public class TesteLexer {

	public static void main(String[] args) {

		Lexer lex = new Lexer("arquivos//ifwhile.txt");
		lex.scan();

	}

}
