package br.poo.joao.main;

import java.util.ArrayList;
import java.util.List;

import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Database;
import br.poo.joao.classes.Tabela;
import br.poo.joao.classes.gerador.Gerador;
import br.poo.joao.classes.script.Script;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.Engine;
import br.poo.joao.factory.FabricaDeDadoNumerico;
import br.poo.joao.factory.FabricaDeDadoTexto;
import br.poo.joao.factory.IFabricaDeDado;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

public class TesteScriptDatabase4 {

	public static void main(String[] args) {
		
		List<Campo> campos = new ArrayList<Campo>();
		List<Tabela> tabelas = new ArrayList<Tabela>();
		
		IFabricaDeDado fabrica = new FabricaDeDadoNumerico();
		
		IDadoSemParametro dadoSemUmParametro = fabrica.criarDadoSemParametro("INT");
		
		Campo campo = new Campo(dadoSemUmParametro);
		campo.comOnome("codigo").comChavePrimaria(true).comColunaAutoIncremento(true);
		campos.add(campo);
		
		fabrica = new FabricaDeDadoTexto();
		
		IDadoComUmParametro dadoComUmParametro = fabrica.criarDadoComUmParametro("VARCHAR", 45);
		campo = new Campo(dadoComUmParametro);
		campo.comOnome("descricao").comNotNull(true);
		campos.add(campo);
		
		Tabela tabela = new Tabela(campos);
		tabela.usandoONome("marca").codificadoCom(Collate.SCHEMADEFAULT).utilizandoOMecanismo(Engine.INNODB);
		tabelas.add(tabela);
		campos = new ArrayList<Campo>();
		
		fabrica = new FabricaDeDadoNumerico();
		
		dadoSemUmParametro = fabrica.criarDadoSemParametro("INT");
		
		campo = new Campo(dadoSemUmParametro);
		campo.comOnome("codigo").comChavePrimaria(true).comColunaAutoIncremento(true);
		campos.add(campo);
		
		fabrica = new FabricaDeDadoTexto();
		
		dadoComUmParametro = fabrica.criarDadoComUmParametro("VARCHAR", 45);
		campo = new Campo(dadoComUmParametro);
		campo.comOnome("descricao");
		campos.add(campo);
		
		fabrica = new FabricaDeDadoNumerico();
		
		dadoSemUmParametro = fabrica.criarDadoSemParametro("DOUBLE");
		campo = new Campo(dadoSemUmParametro);
		campo.comOnome("preco");
		campos.add(campo);
		
		fabrica = new FabricaDeDadoTexto();
		
		dadoComUmParametro = fabrica.criarDadoComUmParametro("VARCHAR", 45);
		campo = new Campo(dadoComUmParametro);
		campo.comOnome("codigoBarra");
		campos.add(campo);
		
		tabela = new Tabela(campos).usandoONome("produto").utilizandoOMecanismo(Engine.INNODB);
		
		tabelas.add(tabela);
		
		Database db = new Database(tabelas).usandoONome("bcc").comACollate(Collate.SCHEMADEFAULT);
	//	System.out.println(db);
		
		String sql = Script.gerarScriptDatabase(db);
		
		System.out.println(sql);
		
		Gerador gerador = new Gerador();
		gerador.setNomeDoArquivo("script5");
	//	gerador.gerarTxt(sql);

		
	}

}
