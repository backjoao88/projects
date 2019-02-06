package br.joao.lex;

import java.io.IOException;
import br.joao.utils.FileUtils;

public class Lexer {

	private StringBuilder input;
	private int head = 0;
	int line = 1;

	public Lexer(String filePath) {
		input = new StringBuilder();
		try {
			String strInput = FileUtils.inputFileToString(filePath); // realiza a leitura do arquivo
			input.append(strInput);
		
			jump_white_spaces();
		} catch (IOException e) {
			System.err.println("I/O file error.");
		}
	}

	public StringBuilder getInput() {
		return input;
	}

	public void setInput(StringBuilder input) {
		this.input = input;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public Token nextToken() {
		Token token = new Token();
		int end = 0;
		int finalPosition = 0;
		for (TokenRegex t : TokenRegex.values()) {
			end = t.sizeOfLexem(input.toString());
			/*
			 * passa a string atual para a funcao size Ex: if(x<y){} caso -1, significa que
			 * o regex do token K, não corresponde ao inicio da string atual caso outro
			 * valor, significa que o inicio da string atual correponde ao regex do token K
			 * retornando o index onde termina o lexema inserido da expressão regular
			 *
			 **/

			if (end != -1) {

				if (t.equals(TokenRegex.NEW_LINE)) {
					line++;
				}

				String lexema = input.substring(0, end); // guarda o lexema
				token.setToken(t);
				token.setLexem(lexema); // seta os valores no token
				token.setInitialPosition(head);
				token.setLine(line);
				/* posicao */finalPosition = end;
				/* posicao */ finalPosition = head + end;
				token.setFinalPosition(finalPosition);
				/* posicao */ head = finalPosition;
				input.delete(0, end); // deleta a parte que já foi analisada da string atual.
				return token;
			}
		}
		return null;
	}

	public void scan() {
		Token token;
		while ((token = nextToken()) != null) {
			System.out.println(token);
		}

	}

	public void jump_white_spaces() {
		String strNoSpace = input.toString().replaceAll(" ", ""); // retira da string atual todos os espaços
		input.delete(0, input.length()); // atualiza a string atual
		input.append(strNoSpace);
	}

}
