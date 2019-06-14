package curso.java.jpb.forca;

import java.util.HashSet;
import java.util.Set;

public class Palavra {

	private char[] valor;
	private final char DEFAULT_CARACTER = '_';
	private Set<Character> letrasJogadas = null;

	public Palavra(char[] valor) {
		this.valor = valor;
		letrasJogadas = new HashSet<Character>();
	}

	public char[] getValor() {
		return valor;
	}

	public void setValor(char[] valor) {
		this.valor = valor;
	}

	public int tamanho() {
		return valor.length;
	}

	public Set<Character> getLetrasJogadas() {
		return letrasJogadas;
	}

	public void setLetrasJogadas(Set<Character> letrasJogadas) {
		this.letrasJogadas = letrasJogadas;
	}

	public char getDEFAULT_CARACTER() {
		return DEFAULT_CARACTER;
	}
	
	public boolean repetido(char letra) {
		if(letrasJogadas.contains(letra)){
			return true;
		}
		return false;
	}

	public int contemChar(char letra) {

		int letras = 0;

		for (int i = 0; i < valor.length; i++) {
			if (letra == Character.toLowerCase(valor[i]) || letra == Character.toUpperCase(valor[i])) {
				letras++;
			}
		}
		return letras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < valor.length; i++) {

			// se letras jogadas tem alguma letra de valor, então imprime esta letra

			if (letrasJogadas.contains(Character.toUpperCase(valor[i])) || letrasJogadas.contains(Character.toLowerCase(valor[i]))) {
				builder.append(valor[i]);
				builder.append("     ");
			} else {
				builder.append(DEFAULT_CARACTER);
				builder.append("     ");
			}
		}

		return builder.toString();
	}

}
