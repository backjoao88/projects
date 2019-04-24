package jpb.exercicio3;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private static final int TAMANHO_BUFFER = 5;
	private Stack<Integer> itens = new Stack<Integer>();

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void incrementar(int quantidade) {
		lock.lock();
		try {
			while (itens.size() == TAMANHO_BUFFER) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (itens.size() == 0) {
				condition.signalAll();
			}
			
			itens.push(quantidade);
			
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
			while (itens.size() == 0) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (itens.size() == TAMANHO_BUFFER) {
				condition.signalAll();
			}

			itens.pop();
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
		if(itens.size() == 0) {
			System.out.println("*");
			return;
		}
		
		for (int i = 0; i < itens.size(); i++) {
			System.out.print(itens.get(i)+ " ");
		}
		
		System.out.println();
	}

}
