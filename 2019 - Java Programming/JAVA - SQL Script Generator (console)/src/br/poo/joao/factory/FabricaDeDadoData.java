package br.poo.joao.factory;

import java.util.List;
import br.poo.joao.classes.tiposDados.Date;
import br.poo.joao.classes.tiposDados.Datetime;
import br.poo.joao.classes.tiposDados.Time;
import br.poo.joao.classes.tiposDados.TimeStamp;
import br.poo.joao.classes.tiposDados.Year;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe que representa a fábrica concreta de dados data. Responsável por criar os dados
 * que possuam como tipo Data.
 * 
 * @author João Paulo Back
 * @since 2018 
 * 
 * */

public class FabricaDeDadoData implements IFabricaDeDado{

	@Override
	public IDadoComUmParametro criarDadoComUmParametro(String tipo, int parametroUm) {
		switch(tipo) {
		case "DATETIME":
			Datetime datetime = new Datetime();
			datetime.setParametroUm(parametroUm);
			return datetime;	
		case "TIMESTAMP":
			TimeStamp timestamp = new TimeStamp();
			timestamp.setParametroUm(parametroUm);
			return timestamp;	
		case "TIME":
			Time time = new Time();
			time.setParametroUm(parametroUm);
			return time;	
		case "YEAR":
			Year year = new Year();
			year.setParametroUm(parametroUm);
			return year;	
		}
		return null;
	}

	@Override
	public IDadoSemParametro criarDadoSemParametro(String tipo) {
		switch(tipo) {
		case "DATE":
			Date date = new Date();
			return date;	
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
		// TODO Auto-generated method stub
		return null;
	}


}
