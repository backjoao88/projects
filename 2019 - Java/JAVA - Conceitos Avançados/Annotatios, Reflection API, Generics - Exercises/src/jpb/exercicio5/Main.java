package jpb.exercicio5;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Integer[] integers = new Integer[5];
		integers[0] = 2;
		integers[1] = 6;
		integers[2] = -1;
		integers[3] = -20;
		integers[4] = 10;
		
		Arrays.asList(integers).forEach(k ->{
			System.out.println(k);
		});
		
		int counter = App.countElementsBiggerThan(integers, new Integer(-100));
		
		System.out.println(counter);

	}

}
