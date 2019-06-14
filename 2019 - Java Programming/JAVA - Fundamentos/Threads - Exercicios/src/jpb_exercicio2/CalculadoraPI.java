package jpb_exercicio2;

public class CalculadoraPI implements Runnable {

	private int id = 0;

	private double[] resultados;

	public CalculadoraPI(int id, double[] resultados) {
		this.id = id;
		this.resultados = resultados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double[] getResultados() {
		return resultados;
	}

	public void setResultados(double[] resultados) {
		this.resultados = resultados;
	}

	@Override
	public void run() {

		for (int k = 0; k < Aplicacao.NUM_ITERACOES; k = k + Aplicacao.NUM_THREADS) {

		}

	}

}
