package br.poo.joao.testes;

import br.poo.joao.classes.validacao.ValidadorTabela;
import br.poo.joao.enumeracoes.Collate;
import br.poo.joao.enumeracoes.CollateVersion;
import junit.framework.TestCase;

public class JUnitTestesCollate extends TestCase{
	
	public void testeVersaoCollate1() {
		assertEquals(true, ValidadorTabela.validarVersaoCollate(Collate.BIG5, CollateVersion.BIG5_CHINESE));
	}
	
	public void testeVersaoCollate2() {
		assertEquals(true, ValidadorTabela.validarVersaoCollate(Collate.ASCII, CollateVersion.ASCII_BIN));
	}
	
	public void testeVersaoCollate3() {
		assertEquals(true, ValidadorTabela.validarVersaoCollate(Collate.BINARY, CollateVersion.BINARY_BIN));
	}

}
