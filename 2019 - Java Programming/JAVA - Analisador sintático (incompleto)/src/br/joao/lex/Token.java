package br.joao.lex;

public class Token {

	private TokenRegex token = null;
	private String lexem = null;
	private int initialPosition = 0;
	private int finalPosition = 0;
	private int line = 0;

	public TokenRegex getToken() {
		return token;
	}

	public void setToken(TokenRegex token) {
		this.token = token;
	}

	public String getLexem() {
		return lexem;
	}

	public void setLexem(String lexem) {
		this.lexem = lexem;
	}

	public int getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(int initialPosition) {
		this.initialPosition = initialPosition;
	}

	public int getFinalPosition() {
		return finalPosition;
	}

	public void setFinalPosition(int finalPosition) {
		this.finalPosition = finalPosition;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Token [token=");
		builder.append(token);
		builder.append(", lexem=");
		if (token.equals(TokenRegex.NEW_LINE))
			builder.append("NEW LINE");
		else
			builder.append(lexem);
		builder.append(", initialPosition=");
		builder.append(initialPosition);
		builder.append(", finalPosition=");
		builder.append(finalPosition);
		builder.append(", line=");
		builder.append(line);
		builder.append("]");
		return builder.toString();
	}

}
