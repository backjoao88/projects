package br.poo.joao.classes.tiposDados;

import java.util.List;

import br.poo.joao.classes.DadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComListaParametrosString;

/**
 * 
 * Classe responsável por representar o tipo de dado Set. Extende de DadoComListaParametrosString e 
 * implementa a interface IDadoComListaParametrosString.
 * 
 * @see DadoComListaParametrosString
 * @author João Paulo Back
 * @since 2018
 *
 */

public class Set extends DadoComListaParametrosString implements IDadoComListaParametrosString{
	
	public Set() {
		this.setNome("SET");
	}
	
	public Set comAListaDeParametros(List<String> parametros) {
		this.setParametros(parametros);
		return this;
	}
	
	@Override
	public List<String> valoresLogicosAceitos() {
		modificadoresAceitos.add("PRIMARY KEY");
		modificadoresAceitos.add("NOT NULL");
		modificadoresAceitos.add("UNIQUE");
		modificadoresAceitos.add("GENERATED COLUMN");
		return modificadoresAceitos;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNome()+"(");
		for (int i = 0 ; i < getParametros().size(); i++) {
			if (i == getParametros().size()-1) {
				builder.append("'"+getParametros().get(i)+"'");
			}else {
				builder.append("'"+getParametros().get(i)+"',");
			}
			
		}
		builder.append(")");
		return builder.toString();
	}
	
}
