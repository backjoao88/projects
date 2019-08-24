package jpb.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class AppMapToInt {

	public static void main(String[] args) {

		// Summing with sum() function from IntStream.
		// The mapToInt function returns a IntStream, it has many functions to integers
		// transformations.
		List<String> numeros = new ArrayList<String>();

		numeros.add("5");
		numeros.add("31");
		numeros.add("22");
		numeros.add("14");
		numeros.add("9");
		numeros.add("30");
		numeros.add("18");

		int sum = numeros.stream().mapToInt(string -> Integer.parseInt(string)).sum();
		System.out.println(sum);

	}

}
