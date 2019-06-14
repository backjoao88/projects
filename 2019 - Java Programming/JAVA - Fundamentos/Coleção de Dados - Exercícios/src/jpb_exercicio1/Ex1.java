package jpb_exercicio1;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 
 * Simulador de jogadas feitas em um tabuleiro de jogo da velha
 * 
 * @author João Paulo Back
 *
 */

public class Ex1 {
	
	public static void main(String[] args) {
		
		
		
		Character[][] tabuleiro = new Character[3][3];
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[0].length; j++) {	
				tabuleiro[i][j] = '-';	
			}
		}
		
		Character[] jogada1 = new Character[3];
		
		jogada1[0] = '1';
		jogada1[1] = '0';
		jogada1[2] = 'X';
		
		Character[] jogada2 = new Character[3];
		
		jogada2[0] = '1';
		jogada2[1] = '1';
		jogada2[2] = 'O';
		
		Character[] jogada3 = new Character[3];
		
		jogada3[0] = '1';
		jogada3[1] = '2';
		jogada3[2] = 'O';
		
		LinkedHashSet<Character[]> jogadas = new LinkedHashSet<Character[]>();
		
		jogadas.add(jogada1);
		jogadas.add(jogada2);
		jogadas.add(jogada3);
		
		Iterator<Character[]> iter = jogadas.iterator();
		
		while(iter.hasNext()) {
			Character[] jgds = iter.next();
			int posLinha = Integer.parseInt(jgds[0].toString());
			int posColuna = Integer.parseInt(jgds[1].toString());
			tabuleiro[posLinha][posColuna] = jgds[2];	
		}
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[0].length; j++) {	
				System.out.print(tabuleiro[i][j] + "   ");
			}
			System.out.println();
			System.out.println();
		}
		
	}

}
