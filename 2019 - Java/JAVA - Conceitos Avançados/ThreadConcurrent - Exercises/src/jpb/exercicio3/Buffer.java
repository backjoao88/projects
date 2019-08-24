package jpb.exercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private final int MAX_ITENS_BUFFER = 10;
	private final int MIN_ITENS_BUFFER = 0;

	private int itens = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public int getItens() {
		return itens;
	}

	// 10

	public void incrementar() {
		lock.lock();
		try {
			while (this.itens == MAX_ITENS_BUFFER) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(this.itens == MIN_ITENS_BUFFER) {
				condition.signalAll();
			}
			this.itens = itens + 1;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("Produziu 1 peça --> Buffer: "+this.getItens());
		} finally {
			lock.unlock();
		}
	}


	public void decrementar() {
		lock.lock();
		try {
			while (this.itens == MIN_ITENS_BUFFER) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(this.itens == MAX_ITENS_BUFFER) {
				condition.signalAll();
			}
			this.itens = itens - 1;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("Consumiu 1 peça --> Buffer: "+this.getItens());
		} finally {
			lock.unlock();
		}
	}

	public int getMaxItensBuffer() {
		return MAX_ITENS_BUFFER;
	}

	public int getMinItensBuffer() {
		return MIN_ITENS_BUFFER;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Buffer [itens=");
		builder.append(itens);
		builder.append("]");
		return builder.toString();
	}

}
