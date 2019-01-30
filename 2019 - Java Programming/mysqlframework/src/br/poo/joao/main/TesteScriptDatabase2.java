package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Database;
import br.poo.joao.classes.Tabela;
import br.poo.joao.classes.script.Script;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteScriptDatabase2 {

	public static void main(String[] args) {
		
		List<Campo> listaCampos = new ArrayList<Campo>();
		List<Tabela> listaTab = new ArrayList<Tabela>();
		
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoSemParametro dadoSemParametro = fabrica.criarDadoSemParametro("INT");
		Campo campo = new Campo(dadoSemParametro);
		campo.comChavePrimaria(true).comColunaAutoIncremento(true).comOnome("pessoa_codigo");
		listaCampos.add(campo);
		
		IDadoComDoisParametros dadoComDoisParametros = fabrica.criarDadoDadoComDoisParametros("DECIMAL", 2, 1);
		campo = new Campo(dadoComDoisParametros);
		campo.comNotNull(true).sendoUnico(true).comOnome("pessoa_idade");
		listaCampos.add(campo);
		
		Tabela tabela = new Tabela(listaCampos).usandoONome("pessoa").codificadoCom(Collate.BIG5);
		
		listaTab.add(tabela);
		
		Database db = new Database(listaTab).comACollate(Collate.BIG5).usandoONome("cc");
		
		String scriptConsole = Script.gerarScriptDatabase(db);
	
		
		System.out.println(scriptConsole);
		

	}

}
