package br.poo.joao.classes.tiposDados;
import java.util.List;
import br.poo.joao.classes.DadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;


/**
 * 
 * Classe responsável por representar o tipo de dado Decimal. Extende de DadoComDoisParametros e 
 * implementa a interface IDadoSemParametro, IDadoComUmParametro e IDadoComDoisParametros.
 * 
 * @see DadoComDoisParametros
 * @author João Paulo Back
 * @since 2018
 *
 */

public class Decimal extends DadoComDoisParametros implements IDadoSemParametro, IDadoComUmParametro, IDadoComDoisParametros{
	
	public Decimal() {
		this.setNome("DECIMAL");
	}
	
	public Decimal comOParametroUm(int parametroUm) {
		this.setParametroUm(parametroUm);
		return this;
	}
	
	public Decimal comOParametroDois(int parametroDois) {
		this.setParametroDois(parametroDois);
		return this;
	}
	
	@Override
	public List<String> valoresLogicosAceitos() {
		modificadoresAceitos.add("PRIMARY KEY");
		modificadoresAceitos.add("NOT NULL");
		modificadoresAceitos.add("UNIQUE");
		modificadoresAceitos.add("UNSIGNED");
		modificadoresAceitos.add("ZERO FILL");
		modificadoresAceitos.add("GENERATED COLUMN");
		return modificadoresAceitos;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (getParametroUm() == 0 && getParametroDois() == 0) {
			builder.append(this.getNome());
		}else {
			if (getParametroUm() == 0) {
				builder.append(this.getNome()+"("+getParametroUm()+")");
			}else {
				builder.append(this.getNome()+"("+getParametroUm()+","+getParametroDois()+")");
			}
		}
		return builder.toString();
	}
	

}
