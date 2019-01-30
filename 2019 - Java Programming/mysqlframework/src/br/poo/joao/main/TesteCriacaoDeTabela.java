package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Tabela;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteCriacaoDeTabela {
	
	public static void main(String[] args) {
		
		List<Tabela> tabelas = new ArrayList<Tabela>();
		
		List<Campo> campos = new ArrayList<Campo>();
		
		
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoSemParametro dadoSemParametro = fabrica.criarDadoSemParametro("INT");
		Campo campo = new Campo(dadoSemParametro);
		campo.comOnome("Codigo").comChavePrimaria(true).comColunaAutoIncremento(true);
		campos.add(campo);
		Tabela tabela = new Tabela(campos).usandoONome("PESSOA").codificadoCom(Collate.BIG5).usandoAVersaoDaCodificacao(CollateVersion.ARMSCII_BIN);	
		tabelas.add(tabela);
		
		System.out.println(tabela);
		
	
	}
	
	

}
