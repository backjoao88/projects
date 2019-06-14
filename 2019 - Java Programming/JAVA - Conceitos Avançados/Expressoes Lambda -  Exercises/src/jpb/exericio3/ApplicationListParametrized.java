package jpb.exericio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ApplicationListParametrized {

	public static void main(String[] args) {

		// Double numbers part

		List<Double> unroundedNumbers = Arrays.asList(2.2, 3.24, 5.67, 12.34, 12.27, 30.98);

		Function<Double, Double> functionFloorDoubleNumbers = doubleNumber -> {
			return Math.floor(doubleNumber);
		};

		System.out.println("ArrayList of rounded down doubles: ");
		transform(unroundedNumbers, functionFloorDoubleNumbers).forEach(System.out::println);

		// Strings part

		List<String> loweredCaseStrings = Arrays.asList("ibm", "microsoft", "google", "facebook");

		Function<String, String> functionLeaveStringUpperCase = lowerCaseString -> {
			return lowerCaseString.toUpperCase();
		};

		System.out.println("ArrayList of uppered case strings: ");
		transform(loweredCaseStrings, functionLeaveStringUpperCase).forEach(System.out::println);

	}

	public static <T> List<T> transform(List<T> list, Function<T, T> function) {
		List<T> newTransformedList = new ArrayList<T>();

		list.forEach(element -> {

			T transformedElement = function.apply(element);
			newTransformedList.add(transformedElement);

		});

		return newTransformedList;
	}
}
