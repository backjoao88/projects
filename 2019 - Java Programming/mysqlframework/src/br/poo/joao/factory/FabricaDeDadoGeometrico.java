package br.poo.joao.factory;

import java.util.List;
import br.poo.joao.classes.tiposDados.Geometry;
import br.poo.joao.classes.tiposDados.GeometryCollection;
import br.poo.joao.classes.tiposDados.LineString;
import br.poo.joao.classes.tiposDados.MultiPoint;
import br.poo.joao.classes.tiposDados.MultiPolygon;
import br.poo.joao.classes.tiposDados.MultilineString;
import br.poo.joao.classes.tiposDados.Point;
import br.poo.joao.classes.tiposDados.Polygon;
import br.poo.joao.interfaces.IDadoComDoisParametros;
import br.poo.joao.interfaces.IDadoComListaParametrosString;
import br.poo.joao.interfaces.IDadoComUmParametro;
import br.poo.joao.interfaces.IDadoSemParametro;

/**
 * 
 * Classe que representa a fábrica concreta de dados geométricos. Responsável por criar os dados
 * que possuam como tipo Geométrico.
 * 
 * @author João Paulo Back
 * @since 2018 
 * 
 * */

public class FabricaDeDadoGeometrico implements IFabricaDeDado {

	@Override
	public IDadoComUmParametro criarDadoComUmParametro(String tipo, int parametroUm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDadoSemParametro criarDadoSemParametro(String tipo) {
		switch(tipo) {
		case "GEOMETRY":
			Geometry geometry = new Geometry();
			return geometry;
		case "GEOMETRYCOLLECTION":
			GeometryCollection geometryCollection = new GeometryCollection();
			return geometryCollection;
		case "LINESTRING":
			LineString lineString = new LineString();
			return lineString;
		case "MULTILINESTRING":
			MultilineString multilineString = new MultilineString();
			return multilineString;
		case "MULTIPOINT":
			MultiPoint multiPoint = new MultiPoint();
			return multiPoint;
		case "MULTIPOLYGON":
			MultiPolygon multiPolygon = new MultiPolygon();
			return multiPolygon;
		case "POINT":
			Point point = new Point();
			return point;
		case "POLYGON":
			Polygon polygon = new Polygon();
			return polygon;
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
