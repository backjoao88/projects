package jpb_exercicio1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Aplicacao {

	public static void main(String[] args) throws InterruptedException {

		try (BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));) {

			Sapo[] sapos = new Sapo[3];
			System.out.println("SENHORES SAPOS, CADASTREM-SE NA CORRIDA, É GRATIS!!");
			System.out.println(" ======================= CADASTRAMENTO =======================");
			for (int k = 0; k < sapos.length; k++) {
				System.out.print("Informe o nome do sapo " + (k + 1) + ": ");
				String nome = buff.readLine();
				sapos[k] = new Sapo(nome);
			}

			System.out.println("==============================================================");

			System.out.println("A CORRIDA VAI INICIAR, AGUARDE !!");

			System.out.println("==============================================================\n");

			Thread.sleep(2000);

			System.out.println("A CORRIDA FOI INICIADA !!!!\n");

			for (int k = 0; k < sapos.length; k++) {
				sapos[k].start();
			}

			for (int k = 0; k < sapos.length; k++) {
				sapos[k].join();
			}

			System.out.println("A CORRIDA TERMINOU !!!!");

		} catch (Exception e) {
			System.out.println("Algum erro ocorreu!");
		}

	}

}
