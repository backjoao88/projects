package jpb_exercicio2;

public class Produto implements Comparable<Produto>{
	
	private String nome = null;
	private double valor = 0;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [nome=");
		builder.append(nome);
		builder.append(", valor=");
		builder.append(valor);
		builder.append("]");
		return builder.toString();
	}
	
	
	public boolean equals(Object obj) {
		Produto p = (Produto) obj;
		if (this.valor > p.valor) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		return (int) valor * 5;
	}
	
	
	@Override
	public int compareTo(Produto p) {
		
		if (this.valor > p.valor) {
			return 1;
		}else {
			if (this.valor < p.valor) {
				return -1;
			}
		}
		return 0;
		
	}
	

}
