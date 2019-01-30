package br.poo.joao.interfaces;

import java.util.List;

/**
 * 
 * Interface com as implementações específicas para um dado.
 * 
 * @see Dado
 * @author João Paulo Back
 * @since 2018
 */

public interface IDado {
	
	/**
	 * Método que ao ser invocado, retorna uma lista de Strings com os modificadores aceitos 
	 * pelo Dado que implementou este método.
	 * 
	 * @return - Lista de strings com os modificadores aceitos.
	 */
	
	public List<String> valoresLogicosAceitos();
	
}
