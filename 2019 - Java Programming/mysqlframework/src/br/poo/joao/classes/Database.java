package br.poo.joao.classes;

import java.util.List;
import br.poo.joao.classes.validacao.ValidadorTabela;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;

/**
 * A classe <code>Database</code> é responsável por representar o banco de dados.
 * 
 * @author João Paulo Back
 * @since 2018
 * 
 * */


public class Database {
	
	private String nome = "";
	protected Collate collate = null;
	protected CollateVersion collateVersion = null;
	private List<Tabela> tabelas = null;
	
	public Database(List<Tabela> tabelas) {
		this.tabelas = tabelas;
		this.collateVersion = CollateVersion.DEFAULT_COLLATION;
	}
	public Database usandoONome(String nome) {
		setNome(nome);
		return this;
	}
	public Database comACollate(Collate collate) {
		setCollate(collate);
		return this;
	}
	public Database comAVersaoDaCollate(CollateVersion collateVersion) {
		setCollateVersion(collateVersion);
		return this;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Tabela> getTabelas() {
		return tabelas;
	}
	public void setTabelas(List<Tabela> tabelas) {
		this.tabelas = tabelas;
	}
	public CollateVersion getCollateVersion() {
		return collateVersion;
	}
	
	/**
	 * 
	 * Método responsável por setar o <code>CollateVersion</code> na classe <code>Collate</code>. 
	 * Invoca o método estático <i>validarVersaoCollate</i> da classe <code>ValidadorTabela</code>
	 * para fazer a validação da versão do <code>Collate</code>.
	 * 
	 * @param <b>collateVersion</b> - variável do tipo enum <code>CollateVersion</code> que será setada. 
	 * 
	 * */
	
	public void setCollateVersion(CollateVersion collateVersion) {
		if (ValidadorTabela.validarVersaoCollate(this.collate, collateVersion)) {
			this.collateVersion = collateVersion;
		}
	}
	public Collate getCollate() {
		return collate;
	}
	public void setCollate(Collate collate) {
		this.collate = collate;
	}
	
	public void addTabela(Tabela c) {
		if (c != null) {
			tabelas.add(c);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Database [nome=");
		builder.append(nome);
		builder.append(", collate=");
		builder.append(collate);
		builder.append(", collateVersion=");
		builder.append(collateVersion);
		builder.append(", tabelas=");
		builder.append(tabelas);
		builder.append("]");
		return builder.toString();
	}

		
}
