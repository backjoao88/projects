package jpb.exercicio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ApplicationMethodLocal {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(2, 6, 7, 8, -2, 1);
		System.out.println("Unsorted: ");
		integers.forEach(System.out::println);
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				} else if (o1 == o2) {
					return 0;
				}
				return -1;
			}
		};
		List<Integer> integers2 = ordenar(integers, comparator);
		System.out.println("Sorted: ");
		integers2.forEach(System.out::println);

	}

	private static List<Integer> ordenar(List<Integer> integers, Comparator<Integer> comparator) {

		class Ordenador {

			private List<Integer> integers;
			private Comparator<Integer> comparator;

			public Ordenador(List<Integer> integers, Comparator<Integer> comparator) {
				this.integers = integers;
				this.comparator = comparator;
			}

			public void sort() {
				integers.sort(comparator);
			}

		}

		Ordenador ordenador = new Ordenador(integers, comparator);
		ordenador.sort();
		return ordenador.integers;

	}

}
