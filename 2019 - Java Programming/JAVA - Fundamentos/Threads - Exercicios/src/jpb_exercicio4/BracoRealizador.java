package jpb_exercicio4;

public class BracoRealizador extends Braco {

	private Esteira esteira = null;

	public BracoRealizador(Esteira esteira) {
		this.esteira = esteira;
	}

	public Esteira getEsteira() {
		return esteira;
	}

	public void setEsteira(Esteira esteira) {
		this.esteira = esteira;
	}

	public void apertar() {
		this.esteira.getPeca().setApertado(true);
	}

	public void soldar() {
		this.esteira.getPeca().setSoldado(true);
	}

	public void run() {
		while (true) {
			synchronized (esteira) {

				while ("FORNECEDOR".equals(esteira.getVez()) || "CONSUMIDOR".equals(esteira.getVez())) {
					try {
						esteira.wait();
					} catch (Exception e) {
					}
				}

				apertar();
				System.out.println("O BRAÇO REALIZADOR(2) APERTOU O PARAFUSO DA PEÇA!");
				soldar();
				System.out.println("O BRAÇO REALIZADOR(2) SOLDOU A PEÇA!");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				esteira.setVez("CONSUMIDOR");
				esteira.notifyAll();

				while ("FORNECEDOR".equals(esteira.getVez()) || "CONSUMIDOR".equals(esteira.getVez())) {
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
		builder.append("BracoRealizador [esteira=");
		builder.append(esteira);
		builder.append("]");
		return builder.toString();
	}

}
