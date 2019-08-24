package jpb.exercicio1;

public class ListaEncadeada {

	private Nodo inicial = null;
	private Nodo fim = null;

	class Nodo {
		int valor = 0;
		Nodo prox = null;

		public Nodo(int valor) {
			this.valor = valor;
		}
	}

	public void remover(int valor) {
		if (valor == inicial.valor)
			removerInicio();
		else
			removerMeio(valor);
	}

	private void removerMeio(int valor) {

		Nodo inicialAux = null;
		Nodo fimAux = null;

		Nodo aux = inicial;

		while (aux.valor != valor) {
			Nodo aux2 = new Nodo(aux.valor);
			if (inicialAux == null) {
				inicialAux = aux2;
				fimAux = inicialAux;
			} else {
				fimAux.prox = aux2;
				fimAux = fimAux.prox;
			}
			aux = aux.prox;

		}

		aux = aux.prox;
		fimAux.prox = aux;
		fim = fimAux.prox;
		inicial = inicialAux;
	}

	private void removerInicio() {
		inicial = inicial.prox;
	}

	public void inserir(int valor) {
		if (inicial == null) {
			inicial = new Nodo(valor);
			fim = inicial;
		} else {
			fim.prox = new Nodo(valor);
			fim = fim.prox;
		}
	}

	public void mostrar() {
		if (inicial == fim) {
			System.out.println(inicial.valor);
		} else {
			Nodo aux = inicial;
			while (aux != null) {
				System.out.println(aux.valor);
				aux = aux.prox;
			}
		}

	}

}
