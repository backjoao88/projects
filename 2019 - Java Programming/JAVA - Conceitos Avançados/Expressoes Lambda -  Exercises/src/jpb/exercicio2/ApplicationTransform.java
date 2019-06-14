package jpb.exercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ApplicationTransform {

	public static void main(String[] args) {
		
		List<Integer> integersList = Arrays.asList(4,7,2,-1,9,3,-6);
		
		Function<Integer, Integer> functionDouble = (i1 -> i1*2);
		
		System.out.println("ArrayList of Integers with doubled values: ");
		transform(integersList, functionDouble).forEach(System.out::println);
		
		Function<Integer, Integer> functionInvertSignal = (i1 -> i1*-1);
		
		System.out.println("ArrayList of Integers with numbers signal inverted: ");
		transform(integersList, functionInvertSignal).forEach(System.out::println);
		
	}

	public static List<Integer> transform(List<Integer> integers, Function<Integer, Integer> function) {
		List<Integer> newTransformedIntegerList = new ArrayList<Integer>();

		integers.forEach(integer -> {
			Integer transformedInteger = function.apply(integer);
			newTransformedIntegerList.add(transformedInteger);
		});

		return newTransformedIntegerList;
	}

}
