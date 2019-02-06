package br.joao.semantic;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

	private static SymbolTable instance = null;
	private Map<String, Symbol> symbolTable = new HashMap<String, Symbol>();
	
	private SymbolTable() {

	}

	public static SymbolTable getInstance() {
		if (instance == null)
			return new SymbolTable();
		return instance;
	}

	public void add(String key, Symbol value) {
		symbolTable.put(key, value);
	}

	public void remove(String key) {
		symbolTable.remove(key);
	}

	public Symbol find(String key) {
		return symbolTable.get(key);
	}

	public void print() {
		
		System.out.println("\nTabela de Símbolos\n");

		symbolTable.forEach((key, symbol) -> {

			System.out.println("Key -->" + key + "\n"+"Symbol --> " + symbol.toString()
			+"\n=============================================================================================================");

		});

	}

}
