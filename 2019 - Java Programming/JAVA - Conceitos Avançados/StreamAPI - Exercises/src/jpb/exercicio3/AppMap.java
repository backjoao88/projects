package jpb.exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppMap {

	public static void main(String[] args) {
		
		
		// Summing with Collectors summingInt() function.
		// The summingInt fuction receive a mapper that transform the way of how the sum is made.
		List<String> numeros = new ArrayList<String>();
		
		numeros.add("5");
		numeros.add("31"); 
		numeros.add("22"); 
		numeros.add("14");
		numeros.add("9"); 
		numeros.add("30"); 
		numeros.add("18");
		
		int sum = numeros.stream().
				map(string -> Integer.parseInt(string))
				.collect(Collectors.summingInt(i -> i));
		
		System.out.println(sum);
		

	}

}
