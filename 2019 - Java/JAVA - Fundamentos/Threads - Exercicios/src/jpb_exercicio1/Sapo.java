package jpb_exercicio1;

import static java.lang.Math.random;

public class Sapo extends Thread {

	private String nome = "";
	private int distancia = 0;

	private static final int PULO = 1;
	private static final int DESCANSO = 2;
	private static int COLOCACAO = 0;

	public Sapo(String nome) {
		this.nome = nome;
	}

	public void pular(int distanciaPulo) {
		if ((distanciaPulo + distancia) <= 100) {
			distancia = distancia + distanciaPulo;
		} else {
			distancia = 100;
		}
	}

	public void descansar(long tempoDescanso) {
		try {
			Thread.sleep(tempoDescanso);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		iniciar_corrida();

		mostrar_resultados();

	}

	private void mostrar_resultados() {

		System.out.println(" ============ UM SAPO CHEGOU A LINHA DE CHEGADA!! ============");
		System.out.println(this);
	}

	public void iniciar_corrida() {
		final int FINAL_CORRIDA = 100;
		
		while (true) {
			if (distancia >= FINAL_CORRIDA) {
				break;
			}
			int opcao = (int) (random() * 10) + 1;
			if (opcao == PULO) {
				int distanciaPulo = (int) (random() * 10) + 1;
				pular(distanciaPulo);
				System.out.println("O sapo " + nome + " pulou " + distanciaPulo + " cm.");
			} else {
				if (opcao == DESCANSO) {
					descansar(300);
				}
			}
		}
		COLOCACAO++;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		System.out.println("SAPO " + nome + " OBTEU A COLOCAÇÃO " + COLOCACAO + "!");
		return builder.toString();
	}

}
