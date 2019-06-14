package jpb.exercicio1;

public class Operacao {
	
	@Init
	public double soma(double v1, double v2) {
		System.out.println(v1+v2);
		return v1+v2;
	}
	
	@Init
	public double dividir(double v1, double v2) {
		System.out.println(v1+v2);
		return v1/v2;
	}
	
	@Init(runOnInstantiation = false)
	public double multiplicar(double v1, double v2) {
		System.out.println(v1+v2);
		return v1*v2;
	}

}
