package br.poo.joao.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe <code>Dado</code> é uma classe abstrata responsável por representar um dado em sua essência.
 * 
 * @author João Paulo Back
 * @since 2018
 * @version 1.0
 *  
 */

public abstract class Dado {
	
	private String nome;
	protected List<String> modificadoresAceitos;
	
	public Dado() {
		this.modificadoresAceitos = new ArrayList<String>();
	}
	
	public String getNome() {
		return nome;
	}
	public List<String> getModificadoresAceitos() {
		return modificadoresAceitos;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dado [nome=");
		builder.append(nome);
		builder.append(", modificadoresAceitos=");
		builder.append(modificadoresAceitos);
		builder.append("]");
		return builder.toString();
	}
	
}
