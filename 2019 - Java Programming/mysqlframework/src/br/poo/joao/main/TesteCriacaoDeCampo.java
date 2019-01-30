package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.classes.Campo;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteCriacaoDeCampo {
	
	public static void main(String[] args) {
				
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoSemParametro inteiro = fabrica.criarDadoSemParametro("INT");
		Campo campo = new Campo(inteiro);
		campo.comOnome("Codigo").comChavePrimaria(true).comColunaAutoIncremento(true);
		System.out.println(campo);
	
		fabrica = new FabricaDeDadoTexto();
		IDadoComUmParametro varchar = fabrica.criarDadoComUmParametro("VARCHAR", 45);
		campo = new Campo(varchar);
		campo.comNotNull(true).comOnome("NOME").utilizandoZeroFill(true).comColunaBinaria(true);
		fabrica = new FabricaDeDadoNumerico();
		System.out.println(campo);
		
		IDadoSemParametro idade = fabrica.criarDadoSemParametro("INT");
		campo = new Campo(idade).comOnome("IDADE").sendoUnico(true).comNotNull(true).utilizandoZeroFill(true).comColunaBinaria(true);
		System.out.println(campo);
		
		fabrica = new FabricaDeDadoTexto();
		List<String> par = new ArrayList<String>();
		par.add("a");
		par.add("b");
		IDadoComListaParametrosString variavel = fabrica.criarDadoComListaDeParametrosString("ENUM", par);
		System.out.println(variavel);
		
	}

}
