package curso.java.jpb.testes;

import curso.java.jpb.exceptions.LeituraArquivoException;
import curso.java.jpb.exceptions.PalavraNaoEncontradaException;
import curso.java.jpb.forca.Sorteador;

public class TesteLerPalavra {

	public static void main(String[] args) {
	
		Sorteador sort = Sorteador.getInstance();
		
		try {
			System.out.println(sort.gerarPalavra());
		
		} catch (PalavraNaoEncontradaException e) {
			e.printStackTrace();
		} catch (LeituraArquivoException e) {
			e.printStackTrace();			
		}
		

	}

}
