package br.poo.joao.classes;

import java.util.List;
import br.poo.joao.classes.validacao.ValidadorTabela;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;
import br.poo.joao.enumeracoes.Engine;

/**
 * A classe <code>Tabela</code> é responsável por representar o banco de dados.
 * 
 * @author João Paulo Back
 * @since 2018
 * 
 */

public class Tabela {

	/**
	 * Atributo private do tipo String que representa o nome da Tabela.
	 * 
	 */

	private String nome = "";

	/**
	 * Atributo protected do tipo Collate que representa a codificação de caracteres
	 * da tabela.
	 * 
	 */

	protected Collate collate = null;

	/**
	 * Atributo protected do tipo CollateVersion que representa as versões da
	 * codificação de caracteres da tabela.
	 */

	protected CollateVersion collateVersion = null;

	/**
	 * 
	 * Atributo private do tipo Engine que representa o motor de armazenamento da
	 * tabela
	 * 
	 */

	private Engine engine = null;

	/**
	 * Atributo private do tipo List que representa a lista de campos da tabela
	 * 
	 */

	private List<Campo> campos = null;

	public Tabela(List<Campo> campos) {
		this.campos = campos;
		setEngine(Engine.INNODB);
		setCollate(Collate.SCHEMADEFAULT);
		setCollateVersion(CollateVersion.DEFAULT_COLLATION);
	}

	public Tabela usandoONome(String nome) {
		setNome(nome);
		return this;
	}

	public Tabela codificadoCom(Collate collate) {
		setCollate(collate);
		return this;
	}

	public Tabela usandoAVersaoDaCodificacao(CollateVersion collateVersion) {
		setCollateVersion(collateVersion);
		return this;
	}

	public Tabela utilizandoOMecanismo(Engine engine) {
		setEngine(engine);
		return this;
	}

	public Tabela comAListaDeCampos(List<Campo> campos) {
		setCampos(campos);
		return this;
	}

	// SETS AND GETTERS

	public Collate getCollate() {
		return collate;
	}

	public void setCollate(Collate collate) {
		this.collate = collate;
	}

	public CollateVersion getCollateVersion() {
		return collateVersion;
	}

	/**
	 * 
	 * Método responsável por setar o <code>CollateVersion</code> na classe
	 * <code>Collate</code>. Invoca o método estático <i>validarVersaoCollate</i> da
	 * classe <code>ValidadorTabela</code> para fazer a validação da versão do
	 * <code>Collate</code>.
	 * 
	 * @param <b>collateVersion</b> - variável do tipo enum
	 *        <code>CollateVersion</code> que será setada.
	 * 
	 */

	public void setCollateVersion(CollateVersion collateVersion) {
		if (ValidadorTabela.validarVersaoCollate(this.collate, collateVersion)) {
			this.collateVersion = collateVersion;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}

	public Collate getCodificacao() {
		return collate;
	}

	public void setCodificacao(Collate collate) {
		this.collate = collate;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tabela [nome=");
		builder.append(nome);
		builder.append(", collate=");
		builder.append(collate);
		builder.append(", collateVersion=");
		builder.append(collateVersion);
		builder.append(", engine=");
		builder.append(engine);
		builder.append(", campos=");
		builder.append(campos);
		builder.append("]");
		return builder.toString();
	}

}
