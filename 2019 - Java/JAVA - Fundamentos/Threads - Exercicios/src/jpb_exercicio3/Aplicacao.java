package jpb_exercicio3;

public class Aplicacao {

	public static void main(String[] args) throws InterruptedException {
		
		Buffer buffer = new Buffer();
		
		Produtor p1 = new Produtor(buffer, 1);
		Consumidor c1 = new Consumidor(buffer, 1);
		
		p1.start();
		c1.start();
		
		p1.join();
		c1.join();
		
		
		System.out.println("Fim da aplicação!");
		
		
		
		
		
		

	}

}
