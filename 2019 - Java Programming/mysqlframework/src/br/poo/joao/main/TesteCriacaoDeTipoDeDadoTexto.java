package br.poo.joao.main;

import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteCriacaoDeTipoDeDadoTexto {

	public static void main(String[] args) {
		
		IFabricaDeDado fabrica = new FabricaDeDadoTexto();
		
		IDadoSemParametro dado = fabrica.criarDadoSemParametro("TINY TEXT");
		System.out.println(dado);
		
		IDadoComUmParametro dado2 = fabrica.criarDadoComUmParametro("NCHAR", 4);
		System.out.println(dado2);
		
		dado = fabrica.criarDadoSemParametro("LONG TEXT");
		System.out.println(dado);
		
		dado2 = fabrica.criarDadoComUmParametro("BIT", 2);
		System.out.println(dado2);
		

	}

}
