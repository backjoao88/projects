/*
*Crie uma aplicação que ordena de forma decrescente uma lista de números 
*compreendidos entre 0 e 9. Para fazer esta ordenação, 
*utilize uma instância de um Comparator criado a partir de uma expressão lambda. 
*
*
*/

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationLambdaExercise1{

	public static void main(String[] args){

		Comparator<Integer> comparatorDecrescent = (o1, o2) -> {
			if(o1 > o2){
				return -1;
			}else if(o1 == o2){
				return 0;
			}else{
				return 1;
			}
		};

		List<Integer> integersUnsorted = Arrays.asList(2,-2,-5,10,19,20,-12);


		System.out.println("Unsorted: ");
		integersUnsorted.forEach(System.out::println);
		
		integersUnsorted.sort(comparatorDecrescent);
	
		System.out.println("Sorted: ");
		integersUnsorted.forEach(System.out::println);

	}
}