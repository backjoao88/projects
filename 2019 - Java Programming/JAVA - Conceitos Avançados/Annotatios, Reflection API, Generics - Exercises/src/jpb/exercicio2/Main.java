package jpb.exercicio2;

public class Main {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Carro carro = new Carro();

		System.out.println("Verificar se o carro possui algum atributo setado: ");

		System.out.println(carro);

		System.out.println("\n== Atribuição com Property ==");

		Property.set(carro, "cor", "Vermelho");
		System.out.println("Verificar se o carro possui algum atributo setado: ");

		System.out.println(carro);

		System.out.println("\n== Retorno com Property ==");

		String cor = Property.get(carro, "cor", String.class);

		System.out.println(cor);

	}
}
