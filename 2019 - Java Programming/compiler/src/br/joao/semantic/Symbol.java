package br.joao.semantic;

public class Symbol {

	public enum Categoria {
		IDENTIFICADOR, VETOR, FUNCAO,
	}

	public enum TipoDado {
		INT, STR, REAL, CHARAC, BOOL, VOID
	}

	private String nome = null;
	private TipoDado tipo = null;
	private Categoria categoria = null;
	private int escopo = 0;
	private int inicioDecl = 0;
	private int fimDecl = 0;

	public Symbol() {

	}

	public Symbol(String nome, TipoDado tipo, Categoria cat, int escopo, int inicioDecl, int fimDecl) {
		setNome(nome);
		setTipo(tipo);
		setCategoria(cat);
		setEscopo(escopo);
		setInicioDecl(inicioDecl);
		setFimDecl(fimDecl);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDado getTipo() {
		return tipo;
	}

	public void setTipo(TipoDado tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getEscopo() {
		return escopo;
	}

	public void setEscopo(int escopo) {
		this.escopo = escopo;
	}

	public int getInicioDecl() {
		return inicioDecl;
	}

	public void setInicioDecl(int inicioDecl) {
		this.inicioDecl = inicioDecl;
	}

	public int getFimDecl() {
		return fimDecl;
	}

	public void setFimDecl(int fimDecl) {
		this.fimDecl = fimDecl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Symbol [nome=");
		builder.append(nome);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", escopo=");
		builder.append(escopo);
		builder.append(", inicioDecl=");
		builder.append(inicioDecl);
		builder.append(", fimDecl=");
		builder.append(fimDecl);
		builder.append("]");
		return builder.toString();
	}

}
