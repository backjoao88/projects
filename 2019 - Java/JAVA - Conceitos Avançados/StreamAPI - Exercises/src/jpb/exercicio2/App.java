package jpb.exercicio2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

	/**
	 * Considere a lista de cores abaixo: List<String> cores = Arrays.asList(
	 * "Azul", "Branco", "Preto", "Preto", "Amarelo", "Azul"); Usando a Stream API,
	 * gere uma nova lista com elementos do tipo Papel. Veja abaixo os detalhes
	 * desta classe: public class Papel { public enum Cor { Branco, Preto, Azul,
	 * Amarelo }
	 * 
	 * private int id; private Cor cor;
	 * 
	 * public Papel(int id, Cor cor) { this.id = id; this.cor = cor; }
	 * 
	 * // Métodos getters e setters... }
	 * 
	 * 
	 * Perceba que objetos da classe Papel devem possuir um ID. Este ID deve ser um
	 * número único gerado no momento da criação do objeto. Ele deve iniciar em 1 e
	 * ser incrementado em 1 a cada novo objeto. Dica: Para converter um objeto
	 * String para um elemento do enum Cor, use o método Papel.Cor.valueOf().
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Function<String, Papel> functionStringToPapel = string -> {
			Papel.objCounters++;
			Papel papel = new Papel(Papel.objCounters, Papel.Cor.valueOf(string));
			return papel;
		};


		List<String> cores = Arrays.asList("BRANCO", "PRETO", "AMARELO", "AZUL");
		System.out.println("Only colors as strings: ");
		cores.forEach(System.out::println);
		List<Papel> papeis = cores
				.stream()
				.map(functionStringToPapel)
				.collect(Collectors.toList());
		
		System.out.println("Colors as \"Papel\" object: ");
		papeis.forEach(System.out::println);
	}

}
