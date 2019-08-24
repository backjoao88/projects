package jpb_exercicio4;

public class BracoFornecedor extends Braco {

	private Esteira esteira = null;

	public BracoFornecedor(Esteira esteira) {
		this.esteira = esteira;
	}

	public Esteira getEsteira() {
		return esteira;
	}

	public void setEsteira(Esteira esteira) {
		this.esteira = esteira;
	}

	public void colocar() {
		this.esteira.setPeca(new Peca());
	}

	public void run(){
		while (true) {
			synchronized (esteira) {

				while ("CONSUMIDOR".equals(esteira.getVez()) || "REALIZADOR".equals(esteira.getVez())) {
					try {
						esteira.wait();
					} catch (Exception e) {
					}
				}

				colocar();
				System.out.println("O BRAÇO FORNECEDOR(1) COLOCOU UMA PEÇA NA ESTEIRA!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				esteira.setVez("REALIZADOR");
				esteira.notify();

				while ("REALIZADOR".equals(esteira.getVez()) || "CONSUMIDOR".equals(esteira.getVez())) {
					try {
						esteira.wait();
					} catch (Exception e) {
					}
				}

			} 
		} 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BracoFornecedor [esteira=");
		builder.append(esteira);
		builder.append("]");
		return builder.toString();
	}

}
