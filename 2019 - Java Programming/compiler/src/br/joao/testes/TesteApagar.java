package br.joao.testes;

import br.joao.lex.Lexer;

public class TesteApagar {

	public static void main(String[] args) {

		Lexer lex = new Lexer("arquivos/arquivo.txt");

		lex.jump_white_spaces();

		System.out.println(lex.getInput().toString());

	}

}
