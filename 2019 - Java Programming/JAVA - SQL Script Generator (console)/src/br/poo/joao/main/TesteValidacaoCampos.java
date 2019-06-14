package br.poo.joao.main;

import br.poo.joao.classes.Campo;
import br.poo.joao.factory.FabricaDeDadoData;
import br.poo.joao.factory.FabricaDeDadoGeometrico;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteValidacaoCampos {
	
	public static void main(String[] args) {
		
		
		IFabricaDeDado fabrica = new FabricaDeDadoGeometrico();
		IDadoSemParametro dadoSemParametro = fabrica.criarDadoSemParametro("GEOMETRY");
		Campo campo = new Campo(dadoSemParametro);
		campo.setarTodosTrue();
		System.out.println(campo);
		
		fabrica = new FabricaDeDadoTexto();
		dadoSemParametro = fabrica.criarDadoSemParametro("CHAR");
		campo = new Campo(dadoSemParametro);
		campo.setarTodosTrue();
		campo.setUnsigned(true);
		System.out.println(campo);
		
		fabrica = new FabricaDeDadoNumerico();
		dadoSemParametro = fabrica.criarDadoSemParametro("INT");
		campo = new Campo(dadoSemParametro);
		campo.setarTodosTrue();
		campo.setUnsigned(true);
		campo.setAuto_increment(true);
		System.out.println(campo);
		
		fabrica = new FabricaDeDadoData();
		IDadoComUmParametro dadoComParametro = fabrica.criarDadoComUmParametro("DATETIME", 5);
		campo = new Campo(dadoComParametro);
		campo.setarTodosTrue();
		campo.setUnsigned(true);
		System.out.println(campo);
		
		
	}

}
