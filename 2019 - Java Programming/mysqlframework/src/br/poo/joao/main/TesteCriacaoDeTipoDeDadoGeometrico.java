package br.poo.joao.main;

import br.poo.joao.factory.FabricaDeDadoGeometrico;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteCriacaoDeTipoDeDadoGeometrico {

	public static void main(String[] args) {
		
		IFabricaDeDado fabrica = new FabricaDeDadoGeometrico();
		IDadoSemParametro dado = fabrica.criarDadoSemParametro("GEOMETRY");
		System.out.println(dado);
		
	}

}
