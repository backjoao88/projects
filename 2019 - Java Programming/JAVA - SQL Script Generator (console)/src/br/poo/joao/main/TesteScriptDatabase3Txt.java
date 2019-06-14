package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;
import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Database;
import br.poo.joao.classes.Tabela;
import br.poo.joao.classes.gerador.Gerador;
import br.poo.joao.classes.script.Script;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.factory.FabricaDeDadoData;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteScriptDatabase3Txt {

	public static void main(String[] args) {
		
		List<Campo> listaCampos = new ArrayList<Campo>();
		List<Tabela> listaTab = new ArrayList<Tabela>();
		
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoSemParametro dadoSemParametro = fabrica.criarDadoSemParametro("INT");
		Campo campo = new Campo(dadoSemParametro);
		campo.comChavePrimaria(true).comColunaAutoIncremento(true).comOnome("pessoa_codigo");
		listaCampos.add(campo);
		
		fabrica = new FabricaDeDadoData();
		
		IDadoComUmParametro dadoComUmParametro = fabrica.criarDadoComUmParametro("DATETIME", 2);
		
		campo = new Campo(dadoComUmParametro);
		campo.comGeneratedColumn(true).comNotNull(true).comGeneratedColumnStored(true).comAExpressao("2").comOnome("data");
		listaCampos.add(campo);
		
		Tabela tabela = new Tabela(listaCampos).usandoONome("pessoa").codificadoCom(Collate.BIG5);
		
		listaTab.add(tabela);
		
		Database db = new Database(listaTab).comACollate(Collate.BIG5).usandoONome("cc");
		
		String scriptConsole = Script.gerarScriptDatabase(db);
	
		System.out.println(scriptConsole);
		
		Gerador gerador = new Gerador();
		gerador.comONomeDeArquivo("script4");
	//	gerador.gerarTxt(scriptConsole);
		
	}

}
