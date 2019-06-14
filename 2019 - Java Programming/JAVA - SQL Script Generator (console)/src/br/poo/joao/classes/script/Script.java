package br.poo.joao.classes.script;

import br.poo.joao.classes.Campo;
import br.poo.joao.classes.Database;
import br.poo.joao.classes.Tabela;
import br.poo.joao.classes.validacao.ValidadorScript;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;

/**
 * 
 * 
 * Classe responsável por conter os métodos responsáveis por gerar o script SQL final.
 * Todos seus métodos são estáticos.
 * 
 * @author João Paulo Back
 *
 */

public class Script{
	
	/**
	 * Método estático responsável por gerar o script do database.
	 * Recebe o objeto Database e o transforma seus atributos em um script SQL do tipo String.
	 * 
	 * @param db Objeto que será transformado
	 * @return Retorna o script SQL no formato de String.
	 */
	
	public static String gerarScriptDatabase(Database db) {
		// CREATE SCHEMA `faculdade` DEFAULT CHARACTER SET big5 COLLATE big5_bin ;
		String sql = "";
		if (db.getCollate().equals(Collate.SCHEMADEFAULT)) {
			sql = "CREATE DATABASE `"+db.getNome()+"`;";
		}else {
			if (!db.getCollate().equals(Collate.SCHEMADEFAULT)) {
				sql = "CREATE DATABASE `"+db.getNome()+"` DEFAULT CHARACTER SET "+db.getCollate().getDesc()+";";
				if (!db.getCollateVersion().equals(CollateVersion.DEFAULT_COLLATION)) {
					sql = "CREATE DATABASE `"+db.getNome()+"` DEFAULT CHARACTER SET "+db.getCollate().getDesc() + " COLLATE "+db.getCollateVersion().getDesc()+";";
				}
			}
		}
		sql = sql + "\nUSE `"+db.getNome()+"`;";
		
		String tabelas = "";
		for (int k = 0 ; k < db.getTabelas().size(); k++) {
			tabelas = tabelas + gerarScriptTabela(db.getTabelas().get(k));
		}
		
		String script = sql + tabelas;
		
		return script;
	}
	
	/**
	 * Método estático responsável por gerar o script da tabela.
	 * Recebe o objeto Tabela e o transforma seus atributos em um script SQL do tipo String.
	 * 
	 * @param db Objeto que será transformado
	 * @return Retorna o script SQL no formato de String.
	 */
	
	public static String gerarScriptTabela(Tabela tabela) {
		String camposVariaveis = "";
		String campoExtra = "";
		String campo = "";
		String engine = "";
		String characterset = "";
		String collate = "";
		String pk1 = "";
		int cont = 0;

		String sql = "\nCREATE TABLE `"+tabela.getNome()+"` (\n";
		
		for (int k = 0 ; k < tabela.getCampos().size(); k++) {
			camposVariaveis = camposVariaveis + gerarScriptCampo(tabela.getCampos().get(k)) + "\n";
		}
		
		for (int i = 0 ; i < tabela.getCampos().size(); i++) {
			if (tabela.getCampos().get(i).isPrimary_key()) {
				cont++;
				if (cont == 1) {
					pk1 = tabela.getCampos().get(i).getNome();
				}else {
					pk1 = pk1 + ", "+tabela.getCampos().get(i).getNome();
				}
			}
		}
		
		campoExtra = "\tPRIMARY KEY ("+pk1+"),\n";
		
		for (int i = 0 ; i < tabela.getCampos().size(); i++) {
			if (tabela.getCampos().get(i).isUnique()) {
				campoExtra = campoExtra + "\tUNIQUE INDEX `"+tabela.getCampos().get(i).getNome()+"_UNIQUE` (`"+tabela.getCampos().get(i).getNome()+"` ASC),\n";
			}
		}
		
		engine = "ENGINE = "+ tabela.getEngine().getDesc();
		
		if (!tabela.getCollate().equals(Collate.SCHEMADEFAULT)) {
			characterset = "\nDEFAULT CHARACTER SET = " +tabela.getCollate().getDesc();
			if (!tabela.getCollateVersion().equals(CollateVersion.DEFAULT_COLLATION)) {
				collate = "\nCOLLATE = "+tabela.getCollateVersion().getDesc();
			}
		}
		campo = camposVariaveis + campoExtra;
		
		String campoValidado = ValidadorScript.validarUltimaVirgulaParaDoisPontos(campo)+ engine + characterset + collate +";";
		
		String tabelaScript = sql + campoValidado+"\n" ;
		
		return tabelaScript;
	}
	
	/**
	 * Método estático responsável por gerar o script do campo.
	 * Recebe o objeto Campo e o transforma seus atributos em um script SQL do tipo String.
	 * 
	 * @param db Objeto que será transformado
	 * @return Retorna o script SQL no formato de String.
	 */
	
	public static String gerarScriptCampo(Campo campo) {
		String sql = "\t`"+ campo.getNome()+"` "+campo.getTipoDado();
		String generated = "";
		if(campo.isBinary_column()){
			sql = sql + " BINARY";
		}
		if (campo.isNot_null()) {
			sql = sql + " NOT NULL";
		}else {
			sql = sql + " NULL";
		}
		if(campo.isUnsigned()){
			sql = sql + " UNSIGNED";
		}
		if(campo.isZero_fill()){
			sql = sql + " ZEROFILL";
		}
		if(campo.isAuto_increment()){
			sql = sql + " AUTO_INCREMENT";
		}
		if (campo.isStored()) {
			generated = "STORED";
		}else {
			generated = "VIRTUAL";
		}
		if(campo.isGenerated_column() && campo.getCampoOuExpressao() != null){
			sql = sql + " GENERATED ALWAYS AS ("+campo.getCampoOuExpressao()+") " +generated;
		}else {
			if (campo.getCampoOuExpressao() != null && !campo.isAuto_increment()) {
				sql = sql +" DEFAULT '"+campo.getCampoOuExpressao()+"'";
			}
		}
		
		sql = sql +",";
		return sql;
	}

}

