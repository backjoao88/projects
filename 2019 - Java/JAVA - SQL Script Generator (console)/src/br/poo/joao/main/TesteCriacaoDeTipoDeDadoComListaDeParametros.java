package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComListaParametrosString;

public class TesteCriacaoDeTipoDeDadoComListaDeParametros {

	public static void main(String[] args) {
		
		IFabricaDeDado fabrica = new FabricaDeDadoTexto();
		List<String> parametros = new ArrayList<String>();
		parametros.add("A");
		parametros.add("B");
		parametros.add("C");
		parametros.add("D");
		IDadoComListaParametrosString dado = fabrica.criarDadoComListaDeParametrosString("ENUM", parametros);
		
		System.out.println(dado);
		

	}

}
