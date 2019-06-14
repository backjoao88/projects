package jpb.exercicio1;

import java.util.concurrent.locks.ReentrantLock;

public class Sapo implements Runnable {

	private final int FINAL_CORRIDA = 100;
	public static int COLOCACAO = 0;
	private int codigo = 0;
	private int distanciaPercorrida = 0;
	private ReentrantLock lock = new ReentrantLock();

	public Sapo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	private void descansar(int tempoDescanso) {
		try {
			Thread.sleep(tempoDescanso);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pular(int distanciaPulo) {
		distanciaPercorrida += distanciaPulo;
		if (distanciaPercorrida >= FINAL_CORRIDA) {
			setDistanciaPercorrida(100);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sapo -> ");
		builder.append(codigo);
		builder.append(", percorreu a distância de: ");
		builder.append(distanciaPercorrida);
		builder.append("cm.");
		return builder.toString();
	}

	public void realizar() {

		while (true) {
			int opcaoAcao = (int) (Math.random() * 2);
			if (opcaoAcao == 1) {
				int distanciaPulo = (int) (Math.random() * 10);
				pular(distanciaPulo);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				int tempoDescanso = (int) (Math.random() * 50);
				descansar(tempoDescanso);
			}
			
			if (getDistanciaPercorrida() >= FINAL_CORRIDA) {
				// região crítica
				lock.lock();
				try {
					COLOCACAO++;
				} finally {
					lock.unlock();
				}
				System.out.println("Sapo " + getCodigo() + " terminou em: " + COLOCACAO);
				break;
			}
		}
	}

	@Override
	public void run() {
		realizar();
	}

}
