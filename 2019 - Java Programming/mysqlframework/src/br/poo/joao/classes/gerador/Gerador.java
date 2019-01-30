package br.poo.joao.classes.gerador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Gerador {
	
	private String nomeDoArquivo = "";
	
	public Gerador comONomeDeArquivo(String nome) {
		setNomeDoArquivo(nome);
		return this;
	}
	
	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}
	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public void gerarTxt(String sql) {
		FileWriter file = null;
		PrintWriter print = null;
		
		try {
			file = new FileWriter("scripts/"+getNomeDoArquivo()+".txt");
			print = new PrintWriter(file);
			print.printf(sql);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			print.close();
		}
	}
	
}
