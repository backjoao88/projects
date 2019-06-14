package exercicio1;

import static java.lang.Math.random;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		int initialCounterValue = (int) (random() * 100);

		Buffer buffer = new Buffer(initialCounterValue);
		Thread currentThread = null;

		Scanner scan = new Scanner(System.in);

		System.out.println("O VALOR INICIAL DO CONTADOR É --> " + buffer.getCounter());

		while (true) {
			System.out.print("\nO que você deseja fazer? (I/D): ");
			String opcao = scan.nextLine();
			switch (opcao.charAt(0)) {
			case 'D':
				currentThread = new Thread(new DecreaseThread(buffer));
				break;
			case 'I':
				currentThread = new Thread(new IncreaseThread(buffer));
				break;
			}

			if (opcao.charAt(0) != 'D' && opcao.charAt(0) != 'I') {
				System.out.println("Programa finalizado!");
				scan.close();
				break;
			} else {
				currentThread.start();
				currentThread.join();

			}
		}
	}

}
