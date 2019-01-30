package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Database;
import br.poo.joao.classes.Tabela;
import br.poo.joao.classes.script.Script;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;
import br.poo.joao.enumeracoes.Engine;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteScriptDatabase {
	
	public static void main(String[] args) {
		
		List<Campo> campos = new ArrayList<Campo>();
		List<Tabela> tabelas = new ArrayList<Tabela>();
		
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoSemParametro dadoSemParametro = fabrica.criarDadoSemParametro("INT");
		Campo campo = new Campo(dadoSemParametro);
		campo.comOnome("Codigo").sendoUnico(true).comChavePrimaria(true).comColunaAutoIncremento(true);
		campos.add(campo);
	
		fabrica = new FabricaDeDadoTexto();
		IDadoComUmParametro varchar = fabrica.criarDadoComUmParametro("VARCHAR", 45);
		campo = new Campo(varchar);
		campo.comNotNull(true).comOnome("NOME").comChavePrimaria(true).sendoUnico(true);	
		campos.add(campo);
		
		Tabela tabela = new Tabela(campos).usandoONome("PESSOA").codificadoCom(Collate.BIG5).usandoAVersaoDaCodificacao(CollateVersion.ARMSCII_BIN);	
		tabelas.add(tabela);
		
		campos = new ArrayList<Campo>();
		
		fabrica = new FabricaDeDadoTexto();
		IDadoComUmParametro dadoComUmParametro = fabrica.criarDadoComUmParametro("VARCHAR",50);
		campo = new Campo(dadoComUmParametro);
		campo.comOnome("nome").comChavePrimaria(true).comColunaAutoIncremento(true);
		campos.add(campo);
	
		fabrica = new FabricaDeDadoNumerico();
		IDadoComDoisParametros dadoComDoisParametros = fabrica.criarDadoDadoComDoisParametros("DECIMAL", 5, 4);
		campo = new Campo(dadoComDoisParametros);
		campo.comNotNull(true).comOnome("salario");	
		campos.add(campo);
		
		fabrica = new FabricaDeDadoTexto();
		List<String> parametros = new ArrayList<String>();
		parametros.add("Maça");
		parametros.add("Laranja");
		parametros.add("Morango");
		
		IDadoComListaParametrosString dadoComListaParametrosString = fabrica.criarDadoComListaDeParametrosString("SET", parametros);
		campo = new Campo(dadoComListaParametrosString);
		campo.comNotNull(true).comOnome("frutas");	
		campos.add(campo);
		
		
		tabela = new Tabela(campos).usandoONome("Funcionario").utilizandoOMecanismo(Engine.INNODB).codificadoCom(Collate.ASCII).usandoAVersaoDaCodificacao(CollateVersion.BIG5_CHINESE);
		tabelas.add(tabela);
		Database db = new Database(tabelas).comACollate(Collate.BIG5).usandoONome("faculdade");

		String script = Script.gerarScriptDatabase(db);
		System.out.println(script);
		
	}

}
