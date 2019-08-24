package jpb.exercicio3;

public class Aplicacao {

	public static void main(String[] args) {

		Map<Integer, String> map = new Map<Integer, String>();

		map.put(1, "João Paulo Back");
		map.put(2, "Carlos Tosin");
		map.put(3, "Rodrigo dos Santos");
		map.put(1, "Samuel da Rosa");
		map.put(2, "João PB");

		String value = map.get(3);

		System.out.println("Valor encontrado: "+value);
		
		map.show();

	}

}
