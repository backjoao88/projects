package br.poo.joao.classes.tiposDados;

import java.util.List;
import br.poo.joao.classes.Dado;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe responsável por representar o tipo de dado GeometryCollection. Extende de Dado e 
 * implementa a interface IDadoSemParametro.
 * 
 * @see Dado
 * @author João Paulo Back
 * @since 2018
 *
 */

public class GeometryCollection extends Dado implements IDadoSemParametro{
	
	public GeometryCollection() {
		this.setNome("GEOMETRY COLLECTION");
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
