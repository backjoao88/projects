package jpb.exercicio1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppDegrees {

	public static void main(String[] args) {

		Function<Double, Double> degreeToRadian = degree -> {
			return (degree * Math.PI) / 180;
		};

		List<Double> radiansDegrees = Arrays.asList(90.0, 30.0, 60.0, 45.0, 180.0)
				.stream()
				.map(degreeToRadian)
				.collect(Collectors.toList());

		radiansDegrees.forEach(System.out::println);

	}

}
