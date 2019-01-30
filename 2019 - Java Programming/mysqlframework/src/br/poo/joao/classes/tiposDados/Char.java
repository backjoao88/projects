package br.poo.joao.classes.tiposDados;

import java.util.List;
import br.poo.joao.classes.DadoComUmParametro;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe responsável por representar o tipo de dado Char. Extende de DadoComUmParametro e 
 * implementa a interface IDadoComUmParametro e IDadoSemParametro.
 * 
 * @see DadoComUmParametro
 * @author João Paulo Back
 * @since 2018
 *
 */

public class Char extends DadoComUmParametro implements IDadoComUmParametro, IDadoSemParametro {
	
	public Char() {
		this.setNome("CHAR");
	}
	
	public Char comOParametroUm(int tamanho) {
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
		if (getParametroUm() == 0) {
			builder.append(this.getNome());
		}else {
			builder.append(this.getNome()+"("+getParametroUm()+")");
		}
		return builder.toString();
	}
}
