package jpb_exercicio4;

public class BracoConsumidor extends Braco {

	private Esteira esteira = null;

	public BracoConsumidor(Esteira esteira) {
		this.esteira = esteira;
	}

	public Esteira getEsteira() {
		return esteira;
	}
	public void setEsteira(Esteira esteira) {
		this.esteira = esteira;
	}

	public void retirar() {
		this.getEsteira().setPeca(null);
	}

	public Embalagem embalar() {
		Embalagem embalagem = new Embalagem();
		embalagem.setPeca(esteira.getPeca());
		embalagem.setLacrado(true);
		return embalagem;
	}

	public void run() {
		while (true) {
			synchronized (esteira) {

				while ("FORNECEDOR".equals(esteira.getVez()) || "REALIZADOR".equals(esteira.getVez())) {
					try {
						esteira.wait();
					} catch (Exception e) {
					}
				}

				Embalagem emb = embalar();
				System.out.println("O BRAÇO CONSUMIDOR(3) EMBALOU UMA PEÇA");
				retirar();
				System.out.println("O BRAÇO CONSUMIDOR(3) RETIROU UMA PEÇA DA ESTEIRA!");
				System.out.println(emb);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				esteira.setVez("FORNECEDOR");
				esteira.notifyAll();
				while ("REALIZADOR".equals(esteira.getVez()) || "FORNECEDOR".equals(esteira.getVez())) {
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
		builder.append("BracoConsumidor [esteira=");
		builder.append(esteira);
		builder.append("]");
		return builder.toString();
	}

}
