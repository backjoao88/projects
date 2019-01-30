package br.poo.joao.classes.validacao;

import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;

/**
 * A classe <code>ValidadorTabela</code> é uma classe utilizada para validar os atributos na classe <code>Tabela</code>
 * Esta classe possui métodos estáticos.
 * 
 * @author João Paulo Back
 * @since 2018
 * 
 * */

public class ValidadorTabela {
	
	/**
	 * 
	 * Método responsável por checar se a <code>CollateVersion</code> que está sendo passada por parâmetro
	 * pertence as versões aceitas pelo <code>Collate</code> que também está sendo passado por parâmetro.
	 * 
	 * 
	 * @param collate - Varíavel do tipo <code>Collate</code> onde é checado a existência da versão.
	 * @param collateV - Varíavel do tipo <code>CollateVersion</code> utilizada para checar sua existência 
	 * no <code>Collate</code>
	 * @return - O método retornará TRUE caso o <code>CollateVersion</code> exista no <code>Collate</code>
	 * 
	 */
	
	public static boolean validarVersaoCollate(Collate collate, CollateVersion collateV) {
		for (int k = 0 ; k < collate.getVersoes().size(); k++) {
			if (collateV.equals((collate.getVersoes().get(k)))) {
				return true;
			}
		}
		return false;
	}
	
}
