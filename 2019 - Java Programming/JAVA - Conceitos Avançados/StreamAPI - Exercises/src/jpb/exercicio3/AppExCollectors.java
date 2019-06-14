package jpb.exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppExCollectors {

	public static void main(String[] args) {

		// Function<String, Integer> mapper = string -> Integer.parseInt(string);

		/**
		 * Criação da Lista de Strings.
		 * 
		 */

		List<String> numeros = new ArrayList<String>();
		numeros.add("5");
		numeros.add("31");
		numeros.add("22");
		numeros.add("14");
		numeros.add("9");
		numeros.add("30");
		numeros.add("18");

		/**
		 * Como o ArrayList é composto de Strings, é esperado ao utilizar a função
		 * stream() uma Stream<String> A função stream() serve para converter uma
		 * Collection para uma Stream.
		 */

		Stream<String> streamString = numeros.stream();

		/**
		 * // * // * Transforma a Stream<String> em uma Stream<Integer> pelo método
		 * map(), que recebe uma função // * que ditará como será feita a transformação,
		 * neste caso a transformação // * foi de Strings para Integers. // * A função
		 * map aplica o método da interface funcional Function para todos os elementos
		 * da stream. // * O parâmetro t é o iterator da stream. Ele entra na função e é
		 * retornado como Integer, como no caso: // * // * Integer a =
		 * Integer.parseInt(t); // * // * //
		 */

		Stream<Integer> streamMapping = streamString.map(new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		});

		/**
		 * Como a streamMapping é de inteiros, 
		 * o método collect espera do método toList uma lista de inteiros.
		*/
		
		List<Integer> integers = streamMapping.collect(Collectors.toList());
		integers.forEach(System.out::println);

	}

	public static <K> Set<K> tr(List<K> list) {
		return null;
	}

}
