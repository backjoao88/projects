package curso.java.jpb.forca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import curso.java.jpb.exceptions.JogoForcaException;

public class Jogo {

	private final int MAX_ERROS = 5;
	private Palavra palavra = null;

	private Map<Character, Jogador> jogadas;

	public Jogo() {
		jogadas = new HashMap<Character, Jogador>();
		sortear();
	}

	public Map<Character, Jogador> getJogadas() {
		return jogadas;
	}

	public void setJogadas(Map<Character, Jogador> jogadas) {
		this.jogadas = jogadas;
	}

	public int getMAX_ERROS() {
		return MAX_ERROS;
	}

	public Palavra getPalavra() {
		return palavra;
	}

	public void setPalavra(Palavra palavra) {
		this.palavra = palavra;
	}

	private void sortear() {
		Palavra palavra = null;
		try {
			palavra = Sorteador.getInstance().gerarPalavra();
		} catch (JogoForcaException e) {
			char[] valor_default = new char[1];
			valor_default[0] = '&';
			palavra = new Palavra(valor_default);
			System.err.println(e.getMessage());
		} finally {
			setPalavra(palavra);
		}
	}

	public void iniciarJogo() {

		try (Scanner scan = new Scanner(System.in);) {

			int erros = 0;
			int acertos = 0;
			
			System.out.print("Digite o seu nome: ");
			String nome = scan.nextLine();
			Jogador jogador = new Jogador(nome);
			
			
			System.out.println("Olá "+nome+", Bem Vindo ao Jogo da Forca!");
			System.out.println("A palavra sorteada possui "+palavra.tamanho() + " letras.");
			System.out.println(this.getPalavra() + "\n");
			
			while (true) {
				System.out.print("Digite seu lance: ");
				char letra = scan.nextLine().charAt(0);
				if(this.getPalavra().repetido(letra)) {
					System.out.println("Letra repetida. Por favor, insira outra letra.");
					continue;
				}
				jogadas.put(letra, jogador);
				this.getPalavra().setLetrasJogadas(this.jogadas.keySet());
				int letras = this.getPalavra().contemChar(letra);
				if (letras == 0) {
					erros++;
					
					if (erros >= MAX_ERROS) {
						System.out.println("Jogo encerrado. Você ultrapassou os 5 erros permitidos.");
						break;
					}
					System.out.println("Voce errou uma letra, voce possui mais "+(MAX_ERROS-erros) + " chances.");
				} else {
					acertos += letras;
					
					if (acertos == this.getPalavra().tamanho()) {
						System.out.println("\nParabéns! Você acertou a palavra: " + String.valueOf(this.getPalavra().getValor()).toUpperCase());
						break;
					}else {
						System.out.println("Você acertou uma letra!");
						System.out.println("\n"+this.getPalavra()+"\n");
					}
				}
			}

		}
	}

}
