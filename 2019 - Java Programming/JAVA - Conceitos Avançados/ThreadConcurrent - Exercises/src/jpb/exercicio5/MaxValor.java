package jpb.exercicio5;

public class MaxValor {

	public static Integer max(int v[], Integer maior, Integer n) {

		Integer aux;

		if (n == v.length - 1) {
			return v[n];
		} else {
			aux = v[n];
		}

		if (aux > maior) {
			maior = aux;
		}

		Integer ultimoValor = max(v, maior, n + 1);

		if (ultimoValor > maior) {
			return ultimoValor;
		} else {
			return maior;
		}

	}

	public static Integer maxi(int v[], Integer n) {
		if (n == v.length - 1) {
			return v[n];
		}
		Integer maior = maxi(v, n + 1);
		System.out.println(n);
		if (maior > v[n]) {
			return maior;
		} else {
			return v[n];
		}
	}

}
