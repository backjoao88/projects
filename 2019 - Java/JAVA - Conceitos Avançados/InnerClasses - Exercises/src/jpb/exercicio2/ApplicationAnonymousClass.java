package jpb.exercicio2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ApplicationAnonymousClass {

	public static void main(String[] args) {

		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2) {
					return 1;
				}else if(o1 == o2) {
					return 0;
				}
				return -1;
			}
		};
		System.out.println("Unsorted: ");
		List<Integer> integers = Arrays.asList(2, 6, 7, 8, -2, 1);
		integers.forEach(System.out::println);
		integers.sort(comparator);
		
		System.out.println("Sorted: ");
		integers.forEach(System.out::println);
		

	}

}
