
public class Soma implements Runnable {

	public int Id = 0;
	public int Index = 0;
	public int SomaParcial = 0;
	public int[] ArrayInteiros = null;

	public Soma(int id) {
		this.Id = 0;
		this.Index = 0;
		this.ArrayInteiros = null;
		this.SomaParcial = 0;
	}

	public Soma(int Id, int Inicio, int Fim, int[] ArrayInteiros) {
		this.Id = Id;
		this.Inicio = Inicio;
		this.Fim = Fim;
		this.ArrayInteiros = ArrayInteiros;
		this.SomaParcial = 0;
	}

	@Override
	public void run() {
		for (int Index = Inicio; Index < Fim; Index++) {
			SomaParcial += ArrayInteiros[Index];
		}
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getInicio() {
		return Inicio;
	}

	public void setInicio(int inicio) {
		Inicio = inicio;
	}

	public int getFim() {
		return Fim;
	}

	public void setFim(int fim) {
		Fim = fim;
	}

	public int getSomaParcial() {
		return SomaParcial;
	}

	public void setSomaParcial(int somaParcial) {
		SomaParcial = somaParcial;
	}

	public int[] getArrayInteiros() {
		return ArrayInteiros;
	}

	public void setArrayInteiros(int[] arrayInteiros) {
		ArrayInteiros = arrayInteiros;
	}

}
