package br.poo.joao.classes.validacao;

/**
 * A classe <code>ValidadorScript</code> é uma classe utilizada para validar o script gerado pela classe <code>Script</code>
 * Esta classe possui métodos estáticos.
 * @see <code>Script</code>
 * 
 * 
 * @author João Paulo Back
 * @since 2018
 * 
 * 
 * */

public class ValidadorScript {
	
	/**
	 * 
	 * Método utilizado para substituir a última vírgula gerada pelos campos da tabela por dois pontos.
	 *
	 * 
	 * @param script - Recebe a variável do tipo String que representa o script.
	 * @return - Retorna a variável script validada. A última vírgula da String é substituída por dois pontos.
	 * 
	 */
	
	
	public static String validarUltimaVirgulaParaDoisPontos(String script) {
		char[] chars = script.toCharArray();
		for (int k = chars.length-1; k > 0; k--) {
			if (chars[k] == ',') {
				chars[k] = ')';
				break;
			}else {
				continue;
			}
		}
		return String.valueOf(chars);
	}
}