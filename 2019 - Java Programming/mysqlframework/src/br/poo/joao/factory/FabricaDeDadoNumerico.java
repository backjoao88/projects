package br.poo.joao.factory;

import java.util.List;
import br.poo.joao.classes.tiposDados.BigInt;
import br.poo.joao.classes.tiposDados.Bit;
import br.poo.joao.classes.tiposDados.Decimal;
import br.poo.joao.classes.tiposDados.Double;
import br.poo.joao.classes.tiposDados.Float;
import br.poo.joao.classes.tiposDados.Int;
import br.poo.joao.classes.tiposDados.MediumInt;
import br.poo.joao.classes.tiposDados.Real;
import br.poo.joao.classes.tiposDados.SmallInt;
import br.poo.joao.classes.tiposDados.TinyInt;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe que representa a fábrica concreta de dados númericos. Responsável por criar os dados
 * que possuam como tipo Númerico.
 * 
 * @author João Paulo Back
 * @since 2018 
 * 
 * */

public class FabricaDeDadoNumerico implements IFabricaDeDado {

	@Override
	public IDadoComUmParametro criarDadoComUmParametro(String tipo, int parametroUm) {
		switch(tipo) {
		case "INT":
			Int inteiro = new Int();
			inteiro.comOParametroUm(parametroUm);
			return inteiro;
		case "BIT":
			Bit bit = new Bit();
			bit.comOParametroUm(parametroUm);
			return bit;
		case "DECIMAL":
			Decimal decimal = new Decimal();
			decimal.comOParametroUm(parametroUm);
			return decimal;
		case "BIGINT":
			BigInt bigInt = new BigInt();
			bigInt.comOParametroUm(parametroUm);
			return bigInt;
		case "MEDIUMINT":
			MediumInt mediumInt = new MediumInt();
			mediumInt.setParametroUm(parametroUm);
			return mediumInt;
		case "SMALLINT":
			SmallInt smallInt = new SmallInt();
			smallInt.setParametroUm(parametroUm);
			return smallInt;
		case "TINYINT":
			TinyInt tinyInt = new TinyInt();
			tinyInt.setParametroUm(parametroUm);
			return tinyInt;
		}
		return null;
		
	}

	@Override
	public IDadoSemParametro criarDadoSemParametro(String tipo) {
		switch(tipo) {
		case "REAL":
			Real real = new Real();
			return real;
		case "DOUBLE":
			Double doub = new Double();
			return doub;
		case "FLOAT":
			Float floa = new Float();
			return floa;
		case "INT":
			Int it = new Int();
			return it;
		}
		return null;
	}

	@Override
	public IDadoComDoisParametros criarDadoDadoComDoisParametros(String tipo, int parametroUm, int parametroDois) {
		switch(tipo) {
		case "DECIMAL":
			Decimal decimal = new Decimal();
			decimal.comOParametroUm(parametroUm);
			decimal.comOParametroDois(parametroDois);
			return decimal;
		}
		return null;
	}

	@Override
	public IDadoComListaParametrosString criarDadoComListaDeParametrosString(String tipo, List<String> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

}
