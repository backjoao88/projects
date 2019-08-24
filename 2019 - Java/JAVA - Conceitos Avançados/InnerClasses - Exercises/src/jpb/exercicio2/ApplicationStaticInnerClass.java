package jpb.exercicio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ApplicationStaticInnerClass {
	
	public static class Comparador{
		
		private Comparator<Integer> comparator;
		
		public Comparador(Comparator<Integer> comparator) {
			this.comparator = comparator;
		}
		
		public List<Integer> ordenar(List<Integer> integers) {
			integers.sort(comparator);
			return integers;
		}
		
	}

	public static void main(String[] args) {
		
		List<Integer> integersUnsorted = Arrays.asList(2, 6, 7, 8, -2, 1);
		System.out.println("Unsorted: ");
		integersUnsorted.forEach(System.out::println);
		
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
		
		ApplicationStaticInnerClass.Comparador comparador = new ApplicationStaticInnerClass.Comparador(comparator);
		List<Integer> integersSorted = comparador.ordenar(integersUnsorted);
		
		System.out.println("Sorted: ");
		integersSorted.forEach(System.out::println);
		

	}

}
