package jpb.exercicio1;

public class App {

	public static void main(String[] args) {
		
		ListaEncadeada le = new ListaEncadeada();

		le.inserir(5);
		le.inserir(4);
		le.inserir(2);
		le.inserir(10);
		le.inserir(72);
		le.inserir(15);
		le.inserir(190);
		le.inserir(-7);
		le.inserir(227);
		le.inserir(-20);
		le.remover(190);
		le.remover(5);
		le.remover(227);
		
		le.mostrar();
		
	}

}
