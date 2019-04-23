package jpb.exercicio3;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private static final int TAMANHO_BUFFER = 5;
	private int[] itens = new int[TAMANHO_BUFFER];
	private int proxPosicaoProduzirBuffer = 0;
	private int proxPosicaoConsumirBuffer = 0;
	private int quantidadeItens = 0;

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void incrementar(int quantidade) {
		lock.lock();
		try {
			while (quantidadeItens == TAMANHO_BUFFER) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (quantidadeItens == 0) {
				condition.signalAll();
			}
			itens[proxPosicaoProduzirBuffer] = quantidade;
			proxPosicaoProduzirBuffer = (proxPosicaoProduzirBuffer + 1) % TAMANHO_BUFFER;
			quantidadeItens++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			imprimir();
		} finally {
			lock.unlock();
		}
	}

	public void decrementar() {
		lock.lock();
		try {
			while (quantidadeItens == 0) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (quantidadeItens == TAMANHO_BUFFER) {
				condition.signalAll();
			}

			int qtdItensConsumidos = itens[proxPosicaoConsumirBuffer];
			proxPosicaoConsumirBuffer = (proxPosicaoConsumirBuffer + 1) % TAMANHO_BUFFER;
			quantidadeItens--;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			imprimir();
		} finally {
			lock.unlock();
		}
	}
	
	private void imprimir() {
		int i = proxPosicaoConsumirBuffer;
		int qtdeImpressos = 0;
		
		boolean vazio = true;
		while(qtdeImpressos < quantidadeItens) {
			vazio = false;
			System.out.print(itens[i] + " ");
			i = (i + 1) % TAMANHO_BUFFER;
			qtdeImpressos++;
		}
		
		if(vazio) {
			System.out.print("** Buffer Vazio **");
		}
		
		System.out.println();
	}

}
