package br.poo.joao.main;

import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteCriacaoDeTipoDeDadoNumerico {
	
	public static void main(String[] args) {
		
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoSemParametro dado = fabrica.criarDadoSemParametro("REAL");
		IDadoComDoisParametros dado2 = fabrica.criarDadoDadoComDoisParametros("DECIMAL", 1, 2);
		
		System.out.println(dado);
		System.out.println(dado2);
		
	}

}
