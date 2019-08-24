package br.poo.joao.factory;

import java.util.List;
import br.poo.joao.classes.tiposDados.Bit;
import br.poo.joao.classes.tiposDados.Blob;
import br.poo.joao.classes.tiposDados.Boolean;
import br.poo.joao.classes.tiposDados.Char;
import br.poo.joao.classes.tiposDados.Enum;
import br.poo.joao.classes.tiposDados.Json;
import br.poo.joao.classes.tiposDados.LongText;
import br.poo.joao.classes.tiposDados.MediumText;
import br.poo.joao.classes.tiposDados.NChar;
import br.poo.joao.classes.tiposDados.NVarchar;
import br.poo.joao.classes.tiposDados.Set;
import br.poo.joao.classes.tiposDados.Text;
import br.poo.joao.classes.tiposDados.TinyText;
import br.poo.joao.classes.tiposDados.Varchar;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe que representa a fábrica concreta de dados texto. Responsável por criar os dados
 * que possuam como tipo Texto.
 * 
 * @author João Paulo Back
 * @since 2018 
 * 
 * */

public class FabricaDeDadoTexto implements IFabricaDeDado{

	@Override
	public IDadoComUmParametro criarDadoComUmParametro(String tipo, int parametroUm) {
		switch(tipo) {
		case "CHAR":
			Char cha = new Char();
			cha.comOParametroUm(parametroUm);
			return cha;
		case "NCHAR":
			NChar nchar = new NChar();
			nchar.comOParametroUm(parametroUm);
			return nchar;
		case "NVARCHAR":
			NVarchar nvarchar = new NVarchar();
			nvarchar.comOParametroUm(parametroUm);
			return nvarchar;
		case "VARCHAR":
			Varchar varchar = new Varchar();
			varchar.comOParametroUm(parametroUm);
			return varchar;
		case "TEXT":
			Text text = new Text();
			text.comOParametroUm(parametroUm);
			return text;
		case "BIT":
			Bit bit = new Bit();
			bit.comOParametroUm(parametroUm);
			return bit;
		case "BLOB":
			Blob blob = new Blob();
			blob.comOParametroUm(parametroUm);
			return blob;
		}
		return null;
	}

	@Override
	public IDadoSemParametro criarDadoSemParametro(String tipo) {
		switch(tipo) {
		case "CHAR":
			Char chare = new Char();
			return chare;
		case "JSON":
			Json json = new Json();
			return json;
		case "LONGTEXT":
			LongText longText = new LongText();
			return longText;
		case "MEDIUMTEXT":
			MediumText mediumText = new MediumText();
			return mediumText;	
		case "TINYTEXT":
			TinyText tinyText = new TinyText();
			return tinyText;	
		case "BOOLEAN":
			Boolean bool = new Boolean();
			return bool;
		case "BLOB":
			Blob blob = new Blob();
			return blob;
		}
		return null;
	}

	@Override
	public IDadoComDoisParametros criarDadoDadoComDoisParametros(String tipo, int parametroUm, int parametroDois) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDadoComListaParametrosString criarDadoComListaDeParametrosString(String tipo, List<String> parametros) {
		switch(tipo) {
		case "SET":
			Set set = new Set();
			set.comAListaDeParametros(parametros);
			return set;
		case "ENUM":
			Enum enu = new Enum();
			enu.comAListaDeParametros(parametros);
			return enu;
		}
		return null;
	}

	

}
