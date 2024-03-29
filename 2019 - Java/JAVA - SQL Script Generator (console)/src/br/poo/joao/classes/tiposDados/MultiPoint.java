package br.poo.joao.classes.tiposDados;

import java.util.List;

import br.poo.joao.classes.Dado;
import br.poo.joao.classes.DadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe respons�vel por representar o tipo de dado MultiPoint. Extende de Dado e 
 * implementa a interface IDadoSemParametro.
 * 
 * @see DadoComUmParametro
 * @author Jo�o Paulo Back
 * @since 2018
 *
 */

public class MultiPoint extends Dado implements IDadoSemParametro{
	
	public MultiPoint() {
		this.setNome("MULTI POINT");
	}
	
	@Override
	public List<String> valoresLogicosAceitos() {
		modificadoresAceitos.add("PRIMARY KEY");
		modificadoresAceitos.add("NOT NULL");
		modificadoresAceitos.add("UNIQUE");
		modificadoresAceitos.add("GENERATED COLUMN");
		return modificadoresAceitos;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getNome());
		return builder.toString();
	}

}
