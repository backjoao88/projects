package br.poo.joao.classes.validacao;

import java.util.List;
import br.poo.joao.interfaces.IDado;

/**
 * A classe <code>ValidadorCampo</code> é uma classe utilizada para validar os atributos na classe <code>Campo</code>
 * Esta classe possui métodos estáticos.
 * 
 * @author João Paulo Back
 * @since 2018
 * 
 * */

public class ValidadorCampo {
	
	/**
	 * 
	 * Método estático utilizado para conferir se um determinado modificador pertence aos modificadores aceitos 
	 * por um determinado tipo de dado.
	 * 
	 * @param tipoDado - Tipo de dado do tipo <code>IDado</code> onde será verificado a existência do modificador.
	 * @param modificador - Modificador do tipo <code>String</code> a ser verificado.
	 * @return - O método retornará TRUE caso o tipo de dado aceite o modificador.
	 * @return - O método retornará FALSE caso o tipo de dado não aceite o modificador.
	 * 
	 */
	
	public static boolean validarModificadoresDado(IDado tipoDado, String modificador) {
		List<String> lista = tipoDado.valoresLogicosAceitos();
		for (int k = 0 ; k < lista.size(); k++) {
			if (modificador.equals(lista.get(k))) {
				return true;
			}
		}
		return false;
	}

}
