package jpb_exercicio4;

public class Aplicacao {

	public static void main(String[] args) { 
		
		Esteira e = new Esteira();
		BracoConsumidor bc = new BracoConsumidor(e);
		BracoFornecedor bf = new BracoFornecedor(e);
		BracoRealizador br = new BracoRealizador(e);
		
		bc.start();
		bf.start();
		br.start();
		
		try {
			bc.join();
			bf.join();
			br.join();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	

	}

}
