package br.poo.joao.testes;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Database;
import br.poo.joao.classes.Tabela;
import br.poo.joao.classes.script.Script;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.Engine;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;
import junit.framework.TestCase;

public class JUnitTestesScript extends TestCase {
	

	public void testeCampo() {
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoComDoisParametros dadoComDoisParametros = fabrica.criarDadoDadoComDoisParametros("DECIMAL", 5, 5);
		Campo campo = new Campo(dadoComDoisParametros)
		.comOnome("salario").
		comColunaAutoIncremento(true);	
		String script = "\t`salario` DECIMAL(5,5) NULL,";	
		assertEquals(script, Script.gerarScriptCampo(campo));
	}
	
	
	public void testeTabela() {
		List<Campo> campos = new ArrayList<Campo>();
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoComUmParametro dadoComUmParametro = fabrica.criarDadoComUmParametro("INT", 5);
		Campo campo = new Campo(dadoComUmParametro);
		campo.comOnome("codigo").comChavePrimaria(true);
		campos.add(campo);
		Tabela tabela = new Tabela(campos).usandoONome("funcionario").codificadoCom(Collate.BIG5).utilizandoOMecanismo(Engine.INNODB);
		
		String script = "\nCREATE TABLE `funcionario` (\n" + 
				"\t`codigo` INT(5) NOT NULL,\n" + 
				"\tPRIMARY KEY (codigo))\n" + 
				"ENGINE = InnoDB\n" + 
				"DEFAULT CHARACTER SET = big5;\n";
		
		assertEquals(script,Script.gerarScriptTabela(tabela));		
	}
	
	public void testeDatabase() {
		List<Tabela> tabelas = new ArrayList<Tabela>();
		List<Campo> campos = new ArrayList<Campo>();
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		IDadoComUmParametro dadoComUmParametro = fabrica.criarDadoComUmParametro("INT", 5);
		Campo campo = new Campo(dadoComUmParametro);
		campo.comOnome("codigo").comChavePrimaria(true);
		campos.add(campo);
		Tabela tabela = new Tabela(campos).usandoONome("funcionario").codificadoCom(Collate.BIG5).utilizandoOMecanismo(Engine.INNODB);
		tabelas.add(tabela);
		Database db = new Database(tabelas).usandoONome("database").comACollate(Collate.BIG5);
		String script = "CREATE DATABASE `database` DEFAULT CHARACTER SET big5;\nUSE `database`;\nCREATE TABLE `funcionario` (\n" + 
				"\t`codigo` INT(5) NOT NULL,\n" + 
				"\tPRIMARY KEY (codigo))\n" + 
				"ENGINE = InnoDB\n" + 
				"DEFAULT CHARACTER SET = big5;\n";
		
		System.out.println(Script.gerarScriptDatabase(db));
		assertEquals(script, Script.gerarScriptDatabase(db));
	}
	
	public void testeDatabase2() {
		List<Tabela> tabelas = new ArrayList<Tabela>();
		List<Campo> campos = new ArrayList<Campo>();
		IFabricaDeDado fabrica = new FabricaDeDadoTexto();
		IDadoSemParametro dadoSemParametro = fabrica.criarDadoSemParametro("CHAR");
		Campo campo = new Campo(dadoSemParametro);
		campo.comOnome("nome").comChavePrimaria(true).comColunaBinaria(true);
		campos.add(campo);
		Tabela tabela = new Tabela(campos).usandoONome("gerente").codificadoCom(Collate.BINARY).utilizandoOMecanismo(Engine.MYISAM);
		tabelas.add(tabela);
		
		Database db = new Database(tabelas).usandoONome("db").comACollate(Collate.BINARY);
		String script = "CREATE DATABASE `db` DEFAULT CHARACTER SET binary;\nUSE `db`;\nCREATE TABLE `gerente` (\n" + 
				"\t`nome` CHAR BINARY NOT NULL,\n" + 
				"\tPRIMARY KEY (nome))\n" + 
				"ENGINE = MyISAM\n" + 
				"DEFAULT CHARACTER SET = binary;\n";
		assertEquals(script, Script.gerarScriptDatabase(db));
	}	
	
}
