package br.poo.joao.classes.tiposDados;

import java.util.List;
import br.poo.joao.classes.DadoComUmParametro;
import br.poo.joao.interfaces.IDadoComUmParametro;

/**
 * 
 * Classe respons�vel por representar o tipo de dado Varchar. Extende de DadoComUmParametro e 
 * implementa a interface IDadoComUmParametro.
 * 
 * @see DadoComUmParametro
 * @author Jo�o Paulo Back
 * @since 2018
 *
 */

public class Varchar extends DadoComUmParametro implements IDadoComUmParametro{
	
	public Varchar() {
		this.setNome("VARCHAR");
	}
	
	public Varchar comOParametroUm(int tamanho) {
		this.setParametroUm(tamanho);
		return this;
	}
	
	@Override
	public List<String> valoresLogicosAceitos() {
		modificadoresAceitos.add("PRIMARY KEY");
		modificadoresAceitos.add("NOT NULL");
		modificadoresAceitos.add("UNIQUE");
		modificadoresAceitos.add("BINARY COLUMN");
		modificadoresAceitos.add("GENERATED COLUMN");
		return modificadoresAceitos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getNome()+"("+getParametroUm()+")");
		return builder.toString();
	}
	
}
