package br.poo.joao.factory;
import java.util.List;

import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Interface que representa uma fábrica genérica que possui 
 * implementações a serem criadas pelas fábricas concretas.
 * 
 * @author João Paulo Back
 * @since 2018 
 * 
 * */

public interface IFabricaDeDado {
	
	/**
	 * {@inheritDoc}
	 * 
	 * Método que cria um dado do tipo que possua um parâmetro. Retorna um objeto que implementa
	 * a interface IDadoComUmParametro.
	 * 
	 * @param tipo - Tipo do dado a ser criado passado como String.
	 * @param parametroUm - Parâmetro do tipo inteiro que o dado possui.
	 * @return - Retorna um objeto do tipo IDadoComUmParametro.
	 * 
	 */
	public IDadoComUmParametro criarDadoComUmParametro(String tipo, int parametroUm);
	
	/**
	 * {@inheritDoc}
	 * 
	 * Método que cria um dado do tipo que não possua nenhum parâmetro. Retorna um objeto que implementa
	 * a interface IDadoSemParametro.
	 * 
	 * @param tipo - Tipo do dado a ser criado passado como String.
	 * @return - Retorna um objeto do tipo IDadoSemParametro.
	 * 
	 */
	
	public IDadoSemParametro criarDadoSemParametro(String tipo);
	
	/**
	 * {@inheritDoc}
	 * 
	 * Método que cria um dado do tipo que possua dois parâmetros. Retorna um objeto que implementa
	 * a interface IDadoComDoisParametros.
	 * 
	 * @param tipo - Tipo do dado a ser criado passado como String.
	 * @param parametroUm - Parâmetro um do tipo inteiro que o dado possui.
	 * @param parametroDois - Parâmetro dois do tipo inteiro que o dado possui.
	 * @return - Retorna um objeto do tipo IDadoComDoisParametros.
	 * 
	 */
	
	
	public IDadoComDoisParametros criarDadoDadoComDoisParametros(String tipo, int parametroUm, int parametroDois);
	
	/**
	 * {@inheritDoc}
	 * 
	 * Método que cria um dado do tipo que possua uma lista de strings como parâmetro. 
	 * Retorna um objeto que implementa a interface IDadoComListaParametrosString.
	 * 
	 * @param tipo - Tipo do dado a ser criado passado como String.
	 * @param parametros - Lista de strings a ser passada como parâmetro.
	 * @return - Retorna um objeto do tipo IDadoComListaParametrosString.
	 * 
	 */
	
	public IDadoComListaParametrosString criarDadoComListaDeParametrosString(String tipo, List<String> parametros);

}
